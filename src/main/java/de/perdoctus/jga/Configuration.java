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

import de.perdoctus.jga.core.UserPreferences;

import java.util.UUID;

/**
 * @author Christoph Giesche
 */
public class Configuration {

	static final String DEFAULT_ENDPOINT_HTTP = "http://www.google-analytics.com/collect";
	static final String DEFAULT_ENDPOINT_HTTPS = "https://ssl.google-analytics.com/collect";
	static final String DEFAULT_PROTOCOL_VERSION = "1";

	private static final String PREF_CLIENT_ID = "clientId";
	private final String trackingId;
	private final String endpointURL;
	private String protocolVersion;
	private String clientId;

	public Configuration(final String trackingId) {
		this(trackingId, DEFAULT_ENDPOINT_HTTP, DEFAULT_PROTOCOL_VERSION, determineClientId());
	}

	public Configuration(final String trackingId, final String endpointURL, final String protocolVersion, final String clientId) {
		this.trackingId = trackingId;
		this.endpointURL = endpointURL;
		this.protocolVersion = protocolVersion;
		this.clientId = clientId;
	}

	private static String determineClientId() {
		String clientId;
		final String newClientId = UUID.randomUUID().toString();
		try {
			final UserPreferences preferences = new UserPreferences("ga4j");
			if (!preferences.containsKey(PREF_CLIENT_ID)) {
				preferences.put(PREF_CLIENT_ID, newClientId);
				preferences.save();
			}
			clientId = preferences.getProperty(PREF_CLIENT_ID);
		} catch (final Exception e) {
			clientId = newClientId;
		}
		return clientId;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public String getEndpointURL() {
		return endpointURL;
	}

	public String getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}
