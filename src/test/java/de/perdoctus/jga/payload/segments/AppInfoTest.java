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
public class AppInfoTest {

	@Test
	public void testApplicationName() throws Exception {
		// given
		final AppInfo appInfo = new AppInfo();

		// when
		final AppInfo resultingAppInfo = appInfo.applicationName("Superapp");

		// then
		assertThat(resultingAppInfo).isSameAs(appInfo);
		assertThat(appInfo.getApplicationName()).isEqualTo("Superapp");

	}

	@Test
	public void testApplicationVersion() throws Exception {
		// given
		final AppInfo appInfo = new AppInfo();

		// when
		final AppInfo resultingAppInfo = appInfo.applicationVersion("1.3");

		// then
		assertThat(resultingAppInfo).isSameAs(appInfo);
		assertThat(appInfo.getApplicationVersion()).isEqualTo("1.3");

	}
}
