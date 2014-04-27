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

import static de.perdoctus.jga.assertj.EnrichedAssertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class EventTest {

	private static final String CATEGORY = "categoryName";
	private static final String ACTION = "actionName";

	@Test
	public void testConstroctor() throws Exception {
		// when
		final Event event = new Event(CATEGORY, ACTION);

		// then
		assertThat(event).isNotNull();
		assertThat(event.getHitType()).isEqualTo(Payload.HitType.EVENT);
		assertThat(event.getCategory()).isEqualTo(CATEGORY);
		assertThat(event.getAction()).isEqualTo(ACTION);

		assertThat(event).hasHitType(Payload.HitType.EVENT);
		assertThat(event).contains(AnalyticsParamNames.KEY_EVENT_CATEGORY, CATEGORY);
		assertThat(event).contains(AnalyticsParamNames.KEY_EVENT_ACTION, ACTION);
	}

	@Test
	public void testLabel() throws Exception {
		// given
		final Event event = new Event(CATEGORY, ACTION);
		final String labelText = "labelText";

		// when
		final Event resultingEvent = event.label(labelText);

		// then
		assertThat(resultingEvent).isEqualTo(event);
		assertThat(resultingEvent.getLabel()).isEqualTo(labelText);

		assertThat(event).hasHitType(Payload.HitType.EVENT);
		assertThat(event).contains(AnalyticsParamNames.KEY_EVENT_CATEGORY, CATEGORY);
		assertThat(event).contains(AnalyticsParamNames.KEY_EVENT_ACTION, ACTION);
		assertThat(event).contains(AnalyticsParamNames.KEY_EVENT_LABEL, labelText);
	}

	@Test
	public void testValue() throws Exception {
		// given
		final Event event = new Event(CATEGORY, ACTION);
		final int value = 22;

		// when
		final Event resultingEvent = event.value(value);

		// then
		assertThat(resultingEvent).isEqualTo(event);
		assertThat(resultingEvent.getValue()).isEqualTo(value);

		assertThat(event).hasHitType(Payload.HitType.EVENT);
		assertThat(event).contains(AnalyticsParamNames.KEY_EVENT_CATEGORY, CATEGORY);
		assertThat(event).contains(AnalyticsParamNames.KEY_EVENT_ACTION, ACTION);
		assertThat(event).contains(AnalyticsParamNames.KEY_EVENT_VALUE, value);
	}
}
