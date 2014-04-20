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

package de.perdoctus.jga.payload.segments;

import de.perdoctus.jga.annotation.AnalyticsParameter;
import de.perdoctus.jga.payload.AnalyticsParamNames;

/**
 * @author Christoph Giesche
 */
public class Session {

	@AnalyticsParameter(AnalyticsParamNames.SESSION_CONTROL)
	private String sessionControl;
	@AnalyticsParameter(AnalyticsParamNames.SESSION_IP_OVERRIDE)
	private String ipOverride;
	@AnalyticsParameter(value = AnalyticsParamNames.SESSION_USER_AGENT_OVERRIDE)
	private String userAgent;

	/**
	 * Used to control the session duration. Forces a new session to start with this hit.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#sc">Session Control</a>
	 */
	public Session sessionControlStart() {
		this.sessionControl = "start";
		return this;
	}

	/**
	 * Used to control the session duration. Forces the current session to end with this hit.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#sc">Session Control</a>
	 */
	public Session sessionControlEnd() {
		this.sessionControl = "end";
		return this;
	}

	/**
	 * The IP address of the user. This should be a valid IP address. It will always be anonymized just as though &aip (anonymize IP) had been used.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#uip">IP Override</a>
	 */
	public Session ipOverride(final String ipOverride) {
		this.ipOverride = ipOverride;
		return this;
	}

	/**
	 * The User Agent of the browser. Note that Google has libraries to identify real user agents. Hand crafting your own agent could break at any time.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ua">User Agent Override</a>
	 */
	public Session userAgent(final String userAgent) {
		this.userAgent = userAgent;
		return this;
	}

	public String getSessionControl() {
		return sessionControl;
	}

	public String getIpOverride() {
		return ipOverride;
	}

	public String getUserAgent() {
		return userAgent;
	}
}
