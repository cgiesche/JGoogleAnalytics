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

import de.perdoctus.jga.Collector;
import de.perdoctus.jga.Configuration;
import de.perdoctus.jga.ConfigurationBuilder;
import org.junit.Test;

/**
 * @author Christoph Giesche
 */
public class ITCollectorTest {

	@Test
	public void testEvent() throws Exception {
		// given
		final Configuration configuration = ConfigurationBuilder.httpEndpoint("UA-28651183-6").build();
		final Collector collector = new Collector(configuration);

		// when
		collector.collect(new Event("Test", "FistTest"));

		for (int i = 0; i < 10; i++) {
			Thread.sleep(2000);
			collector.collect(new Event("Test", "FistTest"));
		}
	}
}
