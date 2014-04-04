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

import de.perdoctus.jga.annotation.AnalyticsParameter;
import de.perdoctus.jga.annotation.Embedded;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class PayloadSerializerTest {

	final PayloadSerializer payloadSerializer = new PayloadSerializer();

	@Test
	public void testSerialize_StringValue() throws Exception {
		// given
		final Object stringValueContent = new Object() {
			@AnalyticsParameter("value")
			final String value = "stringValue";
		};

		// when
		String result = payloadSerializer.serialize(stringValueContent);

		// then
		assertThat(result).isEqualTo("value=stringValue");
	}

	@Test
	public void testSerialize_IntegerValue() throws Exception {
		// given
		final Object stringValueContent = new Object() {
			@AnalyticsParameter("value")
			final Integer value = 1;
		};

		// when
		String result = payloadSerializer.serialize(stringValueContent);

		// then
		assertThat(result).isEqualTo("value=1");
	}

	@Test
	public void testSerialize_IntegerAndStringValue() throws Exception {
		// given
		final Object stringValueContent = new Object() {
			@AnalyticsParameter("iKey")
			final Integer value1 = 1;

			@AnalyticsParameter("sKey")
			final String value2 = "sValue";
		};

		// when
		String result = payloadSerializer.serialize(stringValueContent);

		// then
		assertThat(result).isEqualTo("iKey=1&sKey=sValue");
	}

	@Test
	public void testSerialize_EmbeddedObject() throws Exception {
		// given
		final Object stringValueContent = new Object() {
			@AnalyticsParameter("parent")
			private String value = "parent";

			@Embedded
			final Object embeddedObject = new Object() {
				@AnalyticsParameter("embedded")
				private String value = "value";
			};

		};

		// when
		String result = payloadSerializer.serialize(stringValueContent);

		// then
		assertThat(result).isEqualTo("parent=parent&embedded=value");
	}

	@Test
	public void testSerialize_NullObject() throws Exception {
		// when
		String result = payloadSerializer.serialize(null);

		// then
		assertThat(result).isNotNull().isEmpty();
	}

	@Test
	public void testSerialize_EmbeddedNullObject() throws Exception {
		// given
		final Object stringValueContent = new Object() {
			@AnalyticsParameter("parent")
			private String value = "parent";

			@Embedded
			final Object embeddedObject = new Object() {
				@AnalyticsParameter("embedded")
				private String value = null;
			};

		};

		// when
		String result = payloadSerializer.serialize(stringValueContent);

		// then
		assertThat(result).isEqualTo("parent=parent");
	}

}
