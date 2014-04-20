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

package de.perdoctus.jga.payload;

import de.perdoctus.jga.annotation.AnalyticsParameter;

/**
 * @author Christoph Giesche
 */
public class Social extends Payload<Social> {

	@AnalyticsParameter(AnalyticsParamNames.SOCIAL_NETWORK)
	private final String networkName;
	@AnalyticsParameter(AnalyticsParamNames.SOCIAL_ACTION)
	private final String action;
	@AnalyticsParameter(AnalyticsParamNames.SOCIAL_TARGET)
	private final String target;

	public Social(final String networkName, final String action, final String target) {
		super(HitType.SOCIAL);

		this.networkName = networkName;
		this.action = action;
		this.target = target;
	}

	public String getNetworkName() {
		return networkName;
	}

	public String getAction() {
		return action;
	}

	public String getTarget() {
		return target;
	}
}
