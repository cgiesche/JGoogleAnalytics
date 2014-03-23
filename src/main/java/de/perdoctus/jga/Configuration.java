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

/**
 * @author Christoph Giesche
 */
public class Configuration {

	private final String trackingId;
	private final String endpointURL;
	private String protocolVersion;
	private String clientId;

	public Configuration(String trackingId, String endpointURL, String protocolVersion, String clientId) {
		this.trackingId = trackingId;
		this.endpointURL = endpointURL;
		this.protocolVersion = protocolVersion;
		this.clientId = clientId;
	}

	public String getEndpointURL() {
		return endpointURL;
	}

	public String getTrackingId() {
		return trackingId;
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

	public void setClientId(final String clientId) {
		this.clientId = clientId;
	}
}
