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

import de.perdoctus.jga.payload.segments.ContentInformation;
import org.junit.Test;

/**
 * @author Christoph Giesche
 */
public class PayloadTest extends PayloadTestBase {

	@Test
	public void testConstructor() throws Exception {
		// when
		final Payload payload = new Payload(Payload.HitType.APPVIEW);

		// then
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_HITTYPE, "appview");
	}

	@Test
	public void testAddParameter() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.EVENT);

		// when
		payload.addParameter("foo", "bar");

		// then
		assertSingleParamWithUrlEncodedValue(payload, "foo", "bar");
	}

	@Test
	public void testAddEmptyParameter() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.EVENT);

		// when
		payload.addParameter("foo", "bar");

		// then
		assertParamNotPresent(payload, "foo");
	}

	@Test
	public void testNonInteractive() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.APPVIEW);

		// when
		payload.nonInteractive();

		// then
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_HITTYPE_NONINTERACTIVE, "1");
	}

	@Test
	public void testAnonymizeIP() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.APPVIEW);

		// when
		payload.anonymizeIP();

		// then
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_ANONYMIZE_IP, "1");
	}

	@Test
	public void testSessionStart() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.APPVIEW);

		// when
		payload.sessionControlStart();

		// then
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_SESSION_CONTROL, "start");
	}

	@Test
	public void testSessionEnd() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.APPVIEW);

		// when
		payload.sessionControlEnd();

		// then
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_SESSION_CONTROL, "end");
	}

	@Test
	public void testContentInformation() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.APPVIEW);

		// when
		payload.contentInformation(new ContentInformation().documentHostName("dHostname").documentLocation("/dLoc").documentPath("/dPath").documentTitle("Schöner Titel"));

		// then
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_DOCUMENT_HOST_NAME, "dHostname");
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_DOCUMENT_LOCATION, "/dLoc");
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_DOCUMENT_PATH, "/dPath");
		assertSingleParamWithUrlEncodedValue(payload, Payload.KEY_DOCUMENT_TITLE, "Schöner Titel");
	}

	@Test
	public void testEmptyContentInformation() throws Exception {
		// given
		final Payload payload = new Payload(Payload.HitType.APPVIEW);

		// when
		payload.contentInformation(new ContentInformation());

		// then
		assertParamNotPresent(payload, Payload.KEY_DOCUMENT_HOST_NAME);
		assertParamNotPresent(payload, Payload.KEY_DOCUMENT_LOCATION);
		assertParamNotPresent(payload, Payload.KEY_DOCUMENT_PATH);
		assertParamNotPresent(payload, Payload.KEY_DOCUMENT_TITLE);
	}

}
