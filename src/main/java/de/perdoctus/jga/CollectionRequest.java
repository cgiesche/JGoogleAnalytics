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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Christoph Giesche
 */
public class CollectionRequest implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(Collector.class);
	private final HttpClient httpClient;
	private final HttpRequestBase httpRequest;

	public CollectionRequest(final HttpClient httpClient, final HttpRequestBase httpRequest) {
		this.httpClient = httpClient;
		this.httpRequest = httpRequest;
	}

	@Override
	public void run() {
		try {
			final HttpResponse response = httpClient.execute(httpRequest);
			final StatusLine statusLine = response.getStatusLine();
			final int statusCode = statusLine.getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				LOG.warn("Got Status-Code " + statusCode + ": " + statusLine.getReasonPhrase());
			}

			// Consume responseEntity, if any.
			final HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {
				responseEntity.getContent().close();
			}
		} catch (IOException e) {
			LOG.error("Failed to execute collection request.", e);
		} finally {
			httpRequest.releaseConnection();
		}
	}
}
