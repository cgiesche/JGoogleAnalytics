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
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Christoph Giesche
 */
public class Collector {

	private static final Logger LOG = LoggerFactory.getLogger(Collector.class);
	private final Configuration configuration;
	private final HttpClient httpClient;

	public Collector(final Configuration configuration) {
		this.httpClient = HttpClientBuilder.create().build();
		this.configuration = configuration;
	}

	public Collector(final Configuration configuration, final HttpClient httpClient) {
		this.httpClient = httpClient;
		this.configuration = configuration;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public HttpClient getHttpClient() {
		return httpClient;
	}

	/**
	 * TODO: JavaDoc
	 */
	public void collect(final Payload payload) {
		configure(payload);
		try {
			final HttpPost postRequest = new HttpPost(configuration.getEndpointURL());
			postRequest.setEntity(new StringEntity(payload.toString(), "UTF-8"));
			LOG.info("Sending Request: " + payload.toString());
			final HttpResponse response = httpClient.execute(postRequest);
			final StatusLine statusLine = response.getStatusLine();
			final int statusCode = statusLine.getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				LOG.warn("Got Status-Code " + statusCode + ": " + statusLine.getReasonPhrase());
			}
			response.getEntity().getContent().close();
		} catch (Exception e) {
			LOG.error("Failed to execute collection request.", e);
		}
	}

	private void configure(final Payload payload) {
		payload.addParameter(Payload.KEY_PROTOCOL_VERSION, configuration.getProtocolVersion());
		payload.addParameter(Payload.KEY_TRACKING_ID, configuration.getTrackingId());
		payload.addParameter(Payload.KEY_CLIENT_ID, configuration.getClientId());
	}
}
