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

import java.util.UUID;

/**
 * @author Christoph Giesche
 */
public class ConfigurationBuilder {

	protected static final String ENDPOINT_HTTP = "http://www.google-analytics.com/collect";
	protected static final String ENDPOINT_HTTPS = "https://ssl.google-analytics.com/collect";
	protected static final String DEFAULT_PROTOCOL_VERSION = "1";


	private final Configuration configuration;

	private ConfigurationBuilder(final String trackingId, final String endpointURL) {
		final String clientId = UUID.randomUUID().toString();
		configuration = new Configuration(trackingId, endpointURL, DEFAULT_PROTOCOL_VERSION, clientId);
	}

	public static ConfigurationBuilder httpEndpoint(final String trackingId) {
		return new ConfigurationBuilder(trackingId, ENDPOINT_HTTP);
	}

	public static ConfigurationBuilder httpsEndpoint(final String trackingId) {
		return new ConfigurationBuilder(trackingId, ENDPOINT_HTTPS);
	}

	public static ConfigurationBuilder customEndpoint(final String trackingId, final String endpointURL) {
		return new ConfigurationBuilder(trackingId, endpointURL);
	}

	public Configuration build() {
		return configuration;
	}

	public ConfigurationBuilder withProtocolVersion(final String protocolVersion) {
		configuration.setProtocolVersion(protocolVersion);
		return this;
	}

	public ConfigurationBuilder withClientId(final String clientId) {
		configuration.setClientId(clientId);
		return this;
	}
}
