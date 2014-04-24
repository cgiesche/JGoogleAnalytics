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

package de.perdoctus.jga.assertj;

import de.perdoctus.jga.core.PayloadSerializer;
import de.perdoctus.jga.payload.Payload;
import org.assertj.core.api.AbstractAssert;

import java.net.URLEncoder;

/**
 * @author Christoph Giesche
 */
public class PayloadAssert extends AbstractAssert<PayloadAssert, Payload> {

	private static final PayloadSerializer PAYLOAD_SERIALIZER = new PayloadSerializer();

	protected PayloadAssert(final Payload actual) {
		super(actual, PayloadAssert.class);
	}

	public static PayloadAssert assertThat(final Payload actual) {
		return new PayloadAssert(actual);
	}

	public PayloadAssert contains(final String paramKey, final Object paramValue)
			throws Exception {

		isNotNull();

		final String encodedValue = URLEncoder.encode(paramValue.toString(), "UTF-8");
		final String expectedString = paramKey + '=' + encodedValue;
		final String pattern = "(^|.+&)" + expectedString + "($|&.+)";

		final String serializedPayload = PAYLOAD_SERIALIZER.serialize(actual);

		if (!serializedPayload.matches(pattern)) {
			failWithMessage("Serialized payload <%s> does not contain param <%s> with value <%s>.", serializedPayload, paramKey, encodedValue);
		}

		return this;
	}

	public PayloadAssert doesNotContain(final String paramKey)
			throws Exception {

		isNotNull();
		;
		final String pattern = "(^|.+&)" + paramKey + "=.*($|&.+)";

		final String serializedPayload = PAYLOAD_SERIALIZER.serialize(actual);

		if (serializedPayload.matches(pattern)) {
			failWithMessage("Serialized payload <%s> contains param <%s> but should not.", serializedPayload, paramKey);
		}

		return this;
	}

}
