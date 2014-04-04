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
public class CurrencyValueTest {

	@Test
	public void testValue() throws Exception {
		// given
		final float value = 2.24F;

		// when
		final CurrencyValue currencyValue = new CurrencyValue(value);

		// then
		assertThat(currencyValue.getValue()).isEqualTo(value);
	}

	@Test
	public void testFormat_MaxFractionDigits() throws Exception {
		// given
		final float givenFloat = 1.00000312345F;
		final String expectedString = "1.000003";

		// when
		final CurrencyValue currencyValue = new CurrencyValue(givenFloat);

		// then
		assertThat(currencyValue.toString()).isEqualTo(expectedString);

	}

	@Test
	public void testFormat_MinFractionDigits() throws Exception {
		// given
		final float givenFloat = 1F;
		final String expectedString = "1.0";

		// when
		final CurrencyValue currencyValue = new CurrencyValue(givenFloat);

		// then
		assertThat(currencyValue.toString()).isEqualTo(expectedString);

	}

	@Test
	public void testFormat_MinIntegerDigits() throws Exception {
		// given
		final float givenFloat = .1F;
		final String expectedString = "0.1";

		// when
		final CurrencyValue currencyValue = new CurrencyValue(givenFloat);

		// then
		assertThat(currencyValue.toString()).isEqualTo(expectedString);

	}

}
