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
public class EventIT extends CollectorIntegrationTestBase {

	@Test
	public void testBasicEvent() throws Exception {
		// given
		final Event event = new Event("ITCollectorTest", "testBasicEvent");

		// when
		collector.collect(event);
	}

	@Test
	public void testEventWithLabel() throws Exception {
		// given
		final Event event = new Event("ITCollectorTest", "testEventWithLabel").label("label");

		// when
		collector.collect(event);
	}

	@Test
	public void testEventWithLabelAndValue() throws Exception {
		// given
		final Event event = new Event("ITCollectorTest", "testEventWithLabelAndValue").label("label").value(5);

		// when
		collector.collect(event);
	}
}
