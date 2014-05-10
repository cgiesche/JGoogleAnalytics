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

/**
 * @author Christoph Giesche
 */
public enum BooleanValue {

	TRUE(true),
	FALSE(false);

	private final boolean booleanValue;

	private BooleanValue(final boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public static BooleanValue valueOf(final boolean booleanValue) {
		return booleanValue ? TRUE : FALSE;
	}

	@Override
	public String toString() {
		return  booleanValue ? "1" : "0";
	}

	public boolean toBoolean() {
		return booleanValue;
	}
}
