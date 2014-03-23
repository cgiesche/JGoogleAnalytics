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

import de.perdoctus.jga.Collector;
import de.perdoctus.jga.Configuration;
import de.perdoctus.jga.ConfigurationBuilder;
import de.perdoctus.jga.payload.Event;
import org.junit.Test;

import java.util.UUID;

/**
 * @author Christoph Giesche
 */
public class ITCollectorTest {

	private static final String FIXED_CLIENT_ID = "385b25e8-b70a-41c3-9d21-c36cf027b812";
	private final Configuration configuration = ConfigurationBuilder.httpEndpoint("UA-28651183-6").withClientId(FIXED_CLIENT_ID).build();

	@Test
	public void testBasicEvent() throws Exception {
		// given
		final Collector collector = new Collector(configuration);

		// when
		collector.collect(new Event("ITCollectorTest", "testBasicEvent"));
	}

	@Test
	public void testEventWithLabel() throws Exception {
		// given
		final Collector collector = new Collector(configuration);

		// when
		collector.collect(new Event("ITCollectorTest", "testEventWithLabel").label("label"));
	}

	@Test
	public void testEventWithLabelAndValue() throws Exception {
		// given
		final Collector collector = new Collector(configuration);

		// when
		collector.collect(new Event("ITCollectorTest", "testEventWithLabelAndValue").label("label").value(5));
	}
}
