/*
 * Copyright 2014 Christoph Giesche
 *
 * This file is part of JGoogleAnalytics.
 *
 * JGoogleAnalytics is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JGoogleAnalytics is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JGoogleAnalytics.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.perdoctus.jga;

import de.perdoctus.jga.payload.Payload;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Christoph Giesche
 */
public class Collector {

	private static final Logger LOG = LoggerFactory.getLogger(Collector.class);
	public static final int HTTP_MAX_TOTAL = 10;
	public static final int HTTP_MAX_PER_ROUTE = 10;
	public static final int MAX_THREADS = 10;
	public static final int TERMINATION_TIMEOUT = 2000;
	public static final String USER_AGENT = "Apache-HttpClient/4.3.3 (%s ; %s;)";
	private final ExecutorService executorService;
	private final Configuration configuration;
	private final HttpClient httpClient;

	public Collector(final Configuration configuration) {
		final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(1000, TimeUnit.MILLISECONDS);
		poolingHttpClientConnectionManager.setMaxTotal(HTTP_MAX_TOTAL);
		poolingHttpClientConnectionManager.setDefaultMaxPerRoute(HTTP_MAX_PER_ROUTE);
		final String userAgentString = String.format(USER_AGENT, System.getProperty("os.name"), System.getProperty("os.arch"));

		this.httpClient = HttpClientBuilder
				.create()
				.setUserAgent(userAgentString)
				.setConnectionManager(poolingHttpClientConnectionManager)
				.build();

		this.configuration = configuration;
		this.executorService = Executors.newFixedThreadPool(MAX_THREADS);
		registerShutdownHook();
	}

	public Collector(final Configuration configuration, final HttpClient httpClient, final ExecutorService executorService) {
		this.httpClient = httpClient;
		this.configuration = configuration;
		this.executorService = executorService;
		registerShutdownHook();
	}

	private void registerShutdownHook() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				executorService.shutdown();
				try {
					if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.MILLISECONDS)) {
						LOG.warn("Executor did not terminate in the specified time.");
						final List<Runnable> droppedTasks = executorService.shutdownNow();
						LOG.warn("Executor was abruptly shut down. " + droppedTasks.size() + " tasks will not be executed.");
					}
				} catch (final InterruptedException e) {
					LOG.warn("Executor was interrupted waiting for termination.");
				}
			}
		});
	}

	/**
	 * TODO: JavaDoc
	 */
	public void collect(final Payload payload) {
		configure(payload);

		final HttpPost postRequest = new HttpPost(configuration.getEndpointURL());
		postRequest.setEntity(new StringEntity(payload.getParametersAsString(), "UTF-8"));

		final Thread collectionRequestThread = new Thread(new CollectionRequest(httpClient, postRequest));

		executorService.submit(collectionRequestThread);
	}

	private void configure(final Payload payload) {
		payload.addParameter(Payload.KEY_PROTOCOL_VERSION, configuration.getProtocolVersion());
		payload.addParameter(Payload.KEY_TRACKING_ID, configuration.getTrackingId());
		payload.addParameter(Payload.KEY_CLIENT_ID, configuration.getClientId());
	}
}
