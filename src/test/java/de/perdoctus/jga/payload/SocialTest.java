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

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class SocialTest {

	@Test
	public void testConstructor() throws Exception {
		// when
		final String socialNetworkName = "Facebook";
		final String socialNetworkAction = "like";
		final String socialNetworkTarget = "http://www.foo.com";
		final Social social = new Social(socialNetworkName, socialNetworkAction, socialNetworkTarget);

		// then
		assertThat(social).isNotNull();
		assertThat(social.getHitType()).isEqualTo(Payload.HitType.SOCIAL);
		assertThat(social.getNetworkName()).isEqualTo(socialNetworkName);
		assertThat(social.getAction()).isEqualTo(socialNetworkAction);
		assertThat(social.getTarget()).isEqualTo(socialNetworkTarget);

	}

}
