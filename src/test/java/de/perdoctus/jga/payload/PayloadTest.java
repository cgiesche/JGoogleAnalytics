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

import de.perdoctus.jga.payload.segments.AppInfo;
import de.perdoctus.jga.payload.segments.ContentInformation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class PayloadTest {

	@Test
	public void testConstroctor() throws Exception {
		// when
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};

		// then
		assertThat(payload).isNotNull();
		assertThat(payload.getHitType()).isEqualTo(Payload.HitType.ITEM);
	}

	@Test
	public void testContentInformation() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};
		final ContentInformation givenCallbackInformation = new ContentInformation();

		// when
		final Payload resultingPayload = payload.with(givenCallbackInformation);

		// then
		assertThat(resultingPayload).isSameAs(payload);
		assertThat(payload.getContentInformation()).isSameAs(givenCallbackInformation);
	}

	@Test
	public void testAppInfo() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};
		final AppInfo givenAppInfo = new AppInfo();

		// when
		final Payload resultingPayload = payload.with(givenAppInfo);

		// then
		assertThat(resultingPayload).isSameAs(payload);
		assertThat(payload.getAppInfo()).isSameAs(givenAppInfo);
	}
}
