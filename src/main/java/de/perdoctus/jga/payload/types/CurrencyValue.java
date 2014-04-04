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

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Christoph Giesche
 */
public class CurrencyValue {

	private final float value;

	public CurrencyValue(final float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	@Override
	public String toString() {
		final NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
		numberInstance.setMinimumIntegerDigits(1);
		numberInstance.setMinimumFractionDigits(1);
		numberInstance.setMaximumFractionDigits(6);

		return numberInstance.format(value);
	}

}
