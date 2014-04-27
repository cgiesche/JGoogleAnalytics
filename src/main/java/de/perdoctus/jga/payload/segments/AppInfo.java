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
public class AppInfo {

	@AnalyticsParameter(AnalyticsParamNames.APPLICATION_NAME)
	private String applicationName;
	@AnalyticsParameter(AnalyticsParamNames.APPLICATION_VERSION)
	private String applicationVersion;

	public AppInfo applicationName(final String name) {
		applicationName = name;
		return this;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public AppInfo applicationVersion(String version) {
		this.applicationVersion = version;
		return this;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}
}
