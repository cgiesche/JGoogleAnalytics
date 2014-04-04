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

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.fail;

/**
 * @author Christoph Giesche
 */
public class AnalyticsParamNamesTest {

	/*
	 * Prevent us from accidential duplicate key definition.
	 */
	@Test
	public void testKeysAreUniqe() throws Exception {
		final Field[] declaredFields = AnalyticsParamNames.class.getDeclaredFields();
		final Set<String> analyticsKeys = new HashSet<>(declaredFields.length);

		for (final Field declaredField : declaredFields) {
			if (declaredField.getType() == String.class) {
				final Object value = declaredField.get(new AnalyticsParamNames());
				final String stringValue = (String) value;

				if (stringValue == null || stringValue.isEmpty()) {
					fail(declaredField.getName() + " must contain at least one character.");
				} else if (!analyticsKeys.add(stringValue)) {
					fail(declaredField.getName() + " contains duplicate value '" + stringValue + "'");
				}
			}
		}
	}
}
