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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Christoph Giesche
 */
public class CollectionRequest implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(Collector.class);
	private final String targetURL;
	private final String requestData;

	public CollectionRequest(final String targetURL, final String data) {
		this.targetURL = targetURL;
		this.requestData = data;
	}

	@Override
	public void run() {
		try {
			final URL url = new URL(targetURL);
			final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			postData(urlConnection);

		} catch (final IOException e) {
			LOG.error("Failed to execute collection request.", e);
		}
	}

	protected void postData(final HttpURLConnection urlConnection) throws IOException {
		urlConnection.setRequestMethod("POST");
		urlConnection.setDoOutput(true);
		urlConnection.setUseCaches(false);

		try (OutputStream outputStream = urlConnection.getOutputStream()) {
			outputStream.write(requestData.getBytes("UTF-8"));
		}

		final int responseCode = urlConnection.getResponseCode();

		if (responseCode != HttpURLConnection.HTTP_OK) {
			LOG.warn("Got Status-Code " + responseCode);
		}

		urlConnection.disconnect();
	}
}
