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

package de.perdoctus.jga.payload.types;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class BooleanValueTest {

	@Test
	public void testTrue() throws Exception {
		// given

		// when
		final BooleanValue booleanValue = BooleanValue.valueOf(true);

		// then
		assertThat(booleanValue.toString()).isEqualTo("1");
	}

	@Test
	public void testFalse() throws Exception {
		// given

		// when
		final BooleanValue booleanValue = BooleanValue.valueOf(false);

		// then
		assertThat(booleanValue.toString()).isEqualTo("0");
	}

}
