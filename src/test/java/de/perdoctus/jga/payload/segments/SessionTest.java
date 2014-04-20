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

package de.perdoctus.jga.payload.segments;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class SessionTest {

	@Test
	public void testConstructor() throws Exception {
		// when
		final Session session = new Session();

		// then
		assertThat(session.getIpOverride()).isNull();
		assertThat(session.getSessionControl()).isNull();
		assertThat(session.getUserAgent()).isNull();
	}

	@Test
	public void testIpOverride() throws Exception {
		// given
		final Session session = new Session();
		final String ipOverride = "192.168.178.1";

		// when
		final Session resultingSession = session.ipOverride(ipOverride);

		// then
		assertThat(resultingSession).isSameAs(session);
		assertThat(session.getIpOverride()).isEqualTo(ipOverride);
	}

	@Test
	public void testUserAgent() throws Exception {
		// given
		final Session session = new Session();
		final String userAgent = "Opera/9.80 (Windows NT 6.0) Presto/2.12.388 Version/12.14";

		// when
		final Session resultingSession = session.userAgent(userAgent);

		// then
		assertThat(resultingSession).isSameAs(session);
		assertThat(session.getUserAgent()).isEqualTo(userAgent);
	}

	@Test
	public void testSessionStart() throws Exception {
		// given
		final Session session = new Session();

		// when
		final Session resultingSession = session.sessionControlStart();

		// then
		assertThat(resultingSession).isSameAs(session);
		assertThat(session.getSessionControl()).isEqualTo("start");
	}

	@Test
	public void testSessionEnd() throws Exception {
		// given
		final Session session = new Session();

		// when
		final Session resultingSession = session.sessionControlEnd();

		// then
		assertThat(resultingSession).isSameAs(session);
		assertThat(session.getSessionControl()).isEqualTo("end");
	}

}
