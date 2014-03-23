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

import org.junit.Test;

/**
 * @author Christoph Giesche
 */
public class EventTest extends PayloadTestBase {

	public static final String CATEGORY = "categöry";
	public static final String ACTION = "äction";

	@Test
	public void testConstructor() throws Exception {
		// when
		final Event event = new Event(CATEGORY, ACTION);

		// then
		assertSingleParamWithUrlEncodedValue(event, Event.KEY_EVENT_CATEGORY, "categöry");
		assertSingleParamWithUrlEncodedValue(event, Event.KEY_EVENT_ACTION, "äction");
	}

	@Test
	public void testLabel() throws Exception {
		// given
		final Event event = new Event(CATEGORY, ACTION);

		// when
		event.label("läbel");

		// then
		assertSingleParamWithUrlEncodedValue(event, Event.KEY_EVENT_CATEGORY, "categöry");
		assertSingleParamWithUrlEncodedValue(event, Event.KEY_EVENT_ACTION, "äction");
		assertSingleParamWithUrlEncodedValue(event, Event.KEY_EVENT_LABEL, "läbel");
	}

	@Test
	public void testValue() throws Exception {
		// given
		final Event event = new Event(CATEGORY, ACTION);

		// when
		event.value(22);

		// then
		assertSingleParamWithUrlEncodedValue(event, Event.KEY_EVENT_CATEGORY, "categöry");
		assertSingleParamWithUrlEncodedValue(event, Event.KEY_EVENT_ACTION, "äction");
		assertSingleParamWithUrlEncodedValue(event, Event.KEY_EVENT_VALUE, "22");
	}
}
