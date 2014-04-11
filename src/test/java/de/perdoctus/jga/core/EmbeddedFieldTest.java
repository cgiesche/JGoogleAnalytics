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

package de.perdoctus.jga.core;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class EmbeddedFieldTest {

	@Test
	public void testConstructor() throws Exception {
		// given
		// As Field is final and cannot be mocked, take a field from a class...
		final Field fieldMock = AnalyticsField.class.getDeclaredFields()[0];
		assertThat(fieldMock).isNotNull();

		// when
		final EmbeddedField embeddedField = new EmbeddedField(fieldMock);

		// then
		assertThat(embeddedField.getField()).isSameAs(fieldMock);
	}
}
