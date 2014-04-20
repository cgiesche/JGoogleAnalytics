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
 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#experiments">Content Experiments</a>
 */
public class ContentExperiment {

	@AnalyticsParameter(AnalyticsParamNames.EXPERIMENT_ID)
	private String id;
	@AnalyticsParameter(AnalyticsParamNames.EXPERIMENT_VARIANT)
	private String variant;

	/**
	 * As content experiment should always contain <code>id</code> and <code>variant</code>, consider using the parametrized constructor instead of this one.
	 */
	public ContentExperiment() {

	}

	public ContentExperiment(final String id, final String variant) {
		this.id = id;
		this.variant = variant;
	}

	/**
	 * This parameter specifies that this user has been exposed to an experiment with the given ID. It should be sent in conjunction with the Experiment Variant parameter.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#xid">Experiment ID</a>
	 */
	public ContentExperiment id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * This parameter specifies that this user has been exposed to an experiment with the given ID. It should be sent in conjunction with the Experiment Variant parameter.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#xvar">Experiment Variant</a>
	 */
	public ContentExperiment variant(final String variant) {
		this.variant = variant;
		return this;
	}

	public String getId() {
		return id;
	}


	public String getVariant() {
		return variant;
	}
}
