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

import de.perdoctus.jga.payload.types.BooleanValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class AnalyticsExceptionTest {

	@Test
	public void testConstructor() throws Exception {
		// when
		final AnalyticsException analyticsException = new AnalyticsException();

		// then
		assertThat(analyticsException).isNotNull();
		assertThat(analyticsException.getHitType()).isEqualTo(Payload.HitType.EXCEPTION);
	}

	@Test
	public void testConstructor_Exception() throws Exception {
		// when
		final AnalyticsException analyticsException = new AnalyticsException(new IllegalArgumentException("Foo"));

		// then
		assertThat(analyticsException).isNotNull();
		assertThat(analyticsException.getHitType()).isEqualTo(Payload.HitType.EXCEPTION);
		assertThat(analyticsException.getDescription()).isEqualTo("IllegalArgumentException");
	}

	@Test
	public void testDescription() throws Exception {
		// given
		final AnalyticsException analyticsException = new AnalyticsException();
		final String exceptionDescription = "DatabaseError";

		// when
		final AnalyticsException resultingAnalyticsException = analyticsException.description(exceptionDescription);

		// then
		assertThat(resultingAnalyticsException).isSameAs(analyticsException);
		assertThat(analyticsException.getDescription()).isEqualTo(exceptionDescription);
	}

	@Test
	public void testFatal() throws Exception {
		// given
		final AnalyticsException analyticsException = new AnalyticsException();

		// when
		final BooleanValue booleanValue = BooleanValue.TRUE;
		final AnalyticsException resultingAnalyticsException = analyticsException.fatal(booleanValue);

		// then
		assertThat(resultingAnalyticsException).isSameAs(analyticsException);
		assertThat(analyticsException.getFatal()).isEqualTo(booleanValue);
	}
}
