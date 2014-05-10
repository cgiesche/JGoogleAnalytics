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
import de.perdoctus.jga.payload.segments.ContentExperiment;
import de.perdoctus.jga.payload.segments.ContentInformation;
import de.perdoctus.jga.payload.segments.Session;
import de.perdoctus.jga.payload.types.BooleanValue;
import org.junit.Test;

import static de.perdoctus.jga.assertj.EnrichedAssertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class PayloadTest {

	@Test
	public void testConstructor() throws Exception {
		// when
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};

		// then
		assertThat(payload).isNotNull();
		assertThat(payload.getHitType()).isEqualTo(Payload.HitType.ITEM);

		assertThat(payload).hasHitType(Payload.HitType.ITEM);
	}

	@Test
	public void testContentInformation() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.TIMING) {
		};
		final ContentInformation contentInformation = new ContentInformation();

		// when
		final Payload resultingPayload = payload.with(contentInformation);

		// then
		assertThat(resultingPayload).isSameAs(payload);
		assertThat(payload.getContentInformation()).isSameAs(contentInformation);

		assertThat(payload).hasHitType(Payload.HitType.TIMING);
	}

	@Test
	public void testContentExperiment() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};
		final ContentExperiment contentExperiment = new ContentExperiment();

		// when
		final Payload resultingPayload = payload.with(contentExperiment);

		// then
		assertThat(resultingPayload).isSameAs(payload);
		assertThat(payload.getContentExperiment()).isSameAs(contentExperiment);
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

	@Test
	public void testSession() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};
		final Session session = new Session();

		// when
		final Payload resultingPayload = payload.with(session);

		// then
		assertThat(resultingPayload).isSameAs(payload);
		assertThat(payload.getSession()).isSameAs(session);
	}


	@Test
	public void testNonInteractive() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};

		// when
		final Payload resultingPayload = payload.nonInteractive(true);

		// then
		assertThat(resultingPayload).isSameAs(payload);
		assertThat(payload.getNonInteractive()).isTrue();
	}

	@Test
	public void testAnonymizeIp() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};

		// when
		final Payload resultingPayload = payload.anonymizeIP(true);

		// then
		assertThat(resultingPayload).isSameAs(payload);
		assertThat(payload.isAnonymizeIP()).isTrue();
	}

	@Test
	public void testQueueTime() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.ITEM) {
		};

		// when
		final Payload resultingPayload = payload.queueTime(232);

		// then
		assertThat(resultingPayload).isSameAs(payload);
		assertThat(payload.getQueueTime()).isEqualTo(232);
	}
}
