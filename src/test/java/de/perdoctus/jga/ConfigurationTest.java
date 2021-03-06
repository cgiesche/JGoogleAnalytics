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

package de.perdoctus.jga;

import de.perdoctus.jga.core.UserPreferences;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class ConfigurationTest {

	public static final String TRACKING_ID = "UA-123456-1";
	public static final String ENDPOINT_URL = "http://foo.bar";
	private static final String CLIENT_ID = "12345";
	private static final String PROTOCOL_VERSION = "222";

	@Test
	public void testConstructor() throws Exception {
		// when
		final Configuration configuration = new Configuration(TRACKING_ID, ENDPOINT_URL, PROTOCOL_VERSION, CLIENT_ID);

		// then
		assertThat(configuration.getTrackingId()).isEqualTo(TRACKING_ID);
		assertThat(configuration.getEndpointURL()).isEqualTo(ENDPOINT_URL);
		assertThat(configuration.getClientId()).isEqualTo(CLIENT_ID);
		assertThat(configuration.getProtocolVersion()).isEqualTo(PROTOCOL_VERSION);
	}

	@Test
	public void testConstructor_Defaults() throws Exception {
		// when
		final Configuration configuration = new Configuration(TRACKING_ID);

		// then
		assertThat(configuration.getTrackingId()).isEqualTo(TRACKING_ID);
		assertThat(configuration.getEndpointURL()).isEqualTo(Configuration.DEFAULT_ENDPOINT_HTTP);
		assertThat(configuration.getClientId()).isNotNull();
		assertThat(configuration.getProtocolVersion()).isEqualTo(Configuration.DEFAULT_PROTOCOL_VERSION);
	}

	@Test
	public void testConstructor_ClientIdDiffersAfterPurge() throws Exception {
		// when
		final Configuration initialConfiguration = new Configuration(TRACKING_ID);
		final Configuration secondConfiguration = new Configuration(TRACKING_ID);

		final UserPreferences preferences = new UserPreferences("ga4j");
		preferences.purge();

		final Configuration configurationAfterPurge = new Configuration(TRACKING_ID);


		// then
		assertThat(secondConfiguration.getClientId()).isEqualTo(initialConfiguration.getClientId());
		assertThat(configurationAfterPurge.getClientId()).isNotEqualTo(initialConfiguration.getClientId());
	}

	@Test
	public void testProtocolVersion() throws Exception {
		// given
		final Configuration configuration = new Configuration("foo");

		// when
		configuration.setProtocolVersion("4");

		// then
		assertThat(configuration.getProtocolVersion()).isEqualTo("4");
	}

	@Test
	public void testClientId() throws Exception {
		// given
		final Configuration configuration = new Configuration("foo");

		// when
		configuration.setClientId("FooBar");

		// then
		assertThat(configuration.getClientId()).isEqualTo("FooBar");
	}

}
