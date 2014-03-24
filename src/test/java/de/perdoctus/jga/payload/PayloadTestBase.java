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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public abstract class PayloadTestBase {

	protected void assertSingleParamWithUrlEncodedValue(final Payload payload, final String paramName, final String value) throws UnsupportedEncodingException {
		assertThat(payload.getParametersAsString()).containsOnlyOnce(paramName + "=");
		assertThat(payload.getParametersAsString()).doesNotMatch("[^|&]" + paramName + "=" + urlEncode(value));
	}

	protected void assertParamNotPresent(final Payload payload, final String paramName) {
		assertThat(payload.getParametersAsString()).doesNotMatch("[^|&]" + paramName + "=");
	}

	protected String urlEncode(final String string) throws UnsupportedEncodingException {
		return URLEncoder.encode(string, "UTF-8");
	}

}
