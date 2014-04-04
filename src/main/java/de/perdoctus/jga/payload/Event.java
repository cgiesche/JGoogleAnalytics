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
public class Event extends Payload<Event> {

	@AnalyticsParameter(AnalyticsParamNames.KEY_EVENT_CATEGORY)
	private final String category;
	@AnalyticsParameter(AnalyticsParamNames.KEY_EVENT_ACTION)
	private final String action;
	@AnalyticsParameter(AnalyticsParamNames.KEY_EVENT_LABEL)
	private String label;
	@AnalyticsParameter(AnalyticsParamNames.KEY_EVENT_VALUE)
	private Integer value;

	/**
	 * @param category Specifies the event category. Must not be empty.
	 * @param action   Specifies the event action. Must not be empty.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ec">Event Category</a>
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ea">Event Action</a>
	 */
	public Event(final String category, final String action) {
		super(HitType.EVENT);

		this.category = category;
		this.action = action;
	}

	/**
	 * @param label Specifies the event label.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#el">Event Label</a>
	 */
	public Event label(final String label) {
		this.label = label;
		return this;
	}

	/**
	 * @param value Specifies the event value. Values must be non-negative.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ev">Event Value</a>
	 */
	public Event value(final int value) {
		this.value = value;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public String getAction() {
		return action;
	}

	public String getLabel() {
		return label;
	}

	public Integer getValue() {
		return value;
	}
}
