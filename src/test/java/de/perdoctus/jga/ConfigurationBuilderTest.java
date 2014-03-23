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

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class ConfigurationBuilderTest {

	public static final String TRACKING_ID = "UA-123456-1";

	@Test
	public void testDefaultHttpEndpoint() throws Exception {
		// given
		final ConfigurationBuilder configurationBuilder = ConfigurationBuilder.httpEndpoint(TRACKING_ID);

		// when
		final Configuration configuration = configurationBuilder.build();

		// then
		assertThat(configuration).isNotNull();
		assertThat(configuration.getTrackingId()).isEqualTo(TRACKING_ID);
		assertThat(configuration.getEndpointURL()).isEqualTo(ConfigurationBuilder.ENDPOINT_HTTP);
		assertThat(configuration.getProtocolVersion()).isEqualTo(ConfigurationBuilder.DEFAULT_PROTOCOL_VERSION);
		assertThat(configuration.getClientId()).isNotEmpty();
	}

	@Test
	public void testDefaultHttpsEndpoint() throws Exception {
		// given
		final ConfigurationBuilder configurationBuilder = ConfigurationBuilder.httpsEndpoint(TRACKING_ID);

		// when
		final Configuration configuration = configurationBuilder.build();

		// then
		assertThat(configuration).isNotNull();
		assertThat(configuration.getTrackingId()).isEqualTo(TRACKING_ID);
		assertThat(configuration.getEndpointURL()).isEqualTo(ConfigurationBuilder.ENDPOINT_HTTPS);
		assertThat(configuration.getProtocolVersion()).isEqualTo(ConfigurationBuilder.DEFAULT_PROTOCOL_VERSION);
		assertThat(configuration.getClientId()).isNotEmpty();
	}

	@Test
	public void testCustomEndpoint() throws Exception {
		// given
		final ConfigurationBuilder configurationBuilder = ConfigurationBuilder.customEndpoint(TRACKING_ID, "lolololo");

		// when
		final Configuration configuration = configurationBuilder.build();

		// then
		assertThat(configuration).isNotNull();
		assertThat(configuration.getTrackingId()).isEqualTo(TRACKING_ID);
		assertThat(configuration.getEndpointURL()).isEqualTo("lolololo");
		assertThat(configuration.getProtocolVersion()).isEqualTo(ConfigurationBuilder.DEFAULT_PROTOCOL_VERSION);
		assertThat(configuration.getClientId()).isNotEmpty();
	}

	@Test
	public void testProtocolVersion() throws Exception {
		// given
		final ConfigurationBuilder configurationBuilder = ConfigurationBuilder.httpEndpoint(TRACKING_ID);

		// when
		final ConfigurationBuilder resultingConfigurationBuilder = configurationBuilder.withProtocolVersion("2");

		// then
		assertThat(resultingConfigurationBuilder).isEqualTo(configurationBuilder);
		final Configuration configuration = configurationBuilder.build();
		assertThat(configuration.getProtocolVersion()).isEqualTo("2");
	}

	@Test
	public void testClientId() throws Exception {
		// given
		final ConfigurationBuilder configurationBuilder = ConfigurationBuilder.httpEndpoint(TRACKING_ID);

		// when
		final ConfigurationBuilder resultingConfigurationBuilder = configurationBuilder.withClientId("FooBar");

		// then
		assertThat(resultingConfigurationBuilder).isEqualTo(configurationBuilder);
		final Configuration configuration = configurationBuilder.build();
		assertThat(configuration.getClientId()).isEqualTo("FooBar");
	}

}
