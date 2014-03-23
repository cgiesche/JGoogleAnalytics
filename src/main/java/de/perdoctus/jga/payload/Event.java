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

/**
 * @author Christoph Giesche
 */
public class Event extends Payload<Event> {

	public static final String KEY_EVENT_CATEGORY = "ec";
	public static final String KEY_EVENT_ACTION = "ea";
	public static final String KEY_EVENT_LABEL = "el";
	public static final String KEY_EVENT_VALUE = "ev";

	/**
	 * @param category Specifies the event category. Must not be empty.
	 * @param action   Specifies the event action. Must not be empty.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ec">Event Category</a>
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ea">Event Action</a>
	 */
	public Event(final String category, final String action) {
		super(HitType.EVENT);
		addParameter(KEY_EVENT_CATEGORY, category);
		addParameter(KEY_EVENT_ACTION, action);
	}

	/**
	 * @param label Specifies the event label.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#el">Event Label</a>
	 */
	public Event label(final String label) {
		addParameter(KEY_EVENT_LABEL, label);
		return this;
	}

	/**
	 * @param value Specifies the event value. Values must be non-negative.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ev">Event Value</a>
	 */
	public Event value(final int value) {
		addParameter(KEY_EVENT_VALUE, String.valueOf(value));
		return this;
	}

}
