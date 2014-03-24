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
public class SystemInfoTest {

	@Test
	public void testConstructor() throws Exception {
		// when
		new SystemInfo();
	}

	@Test
	public void testScreenResolution() throws Exception {
		// given
		final SystemInfo systemInfo = new SystemInfo();

		// when
		final SystemInfo resultingSystemInfo = systemInfo.screenResolution(800, 600);

		// then
		assertThat(resultingSystemInfo).isSameAs(systemInfo);
		assertThat(systemInfo.getScreenResolution()).isEqualTo("800x600");
	}

	@Test
	public void testViewportSize() throws Exception {
		// given
		final SystemInfo systemInfo = new SystemInfo();

		// when
		final SystemInfo resultingSystemInfo = systemInfo.viewportSize(322, 498);

		// then
		assertThat(resultingSystemInfo).isSameAs(systemInfo);
		assertThat(systemInfo.getViewportSize()).isEqualTo("322x498");
	}

	@Test
	public void testDocumentEncoding() throws Exception {
		// given
		final SystemInfo systemInfo = new SystemInfo();

		// when
		final SystemInfo resultingSystemInfo = systemInfo.documentEncoding("UTF-8");

		// then
		assertThat(resultingSystemInfo).isSameAs(systemInfo);
		assertThat(systemInfo.getDocumentEncoding()).isEqualTo("UTF-8");
	}

	@Test
	public void testScreenColors() throws Exception {
		// given
		final SystemInfo systemInfo = new SystemInfo();

		// when
		final SystemInfo resultingSystemInfo = systemInfo.screenColors("24-bits");

		// then
		assertThat(resultingSystemInfo).isSameAs(systemInfo);
		assertThat(systemInfo.getScreenColors()).isEqualTo("24-bits");
	}

	@Test
	public void testUserLanguage() throws Exception {
		// given
		final SystemInfo systemInfo = new SystemInfo();

		// when
		final SystemInfo resultingSystemInfo = systemInfo.screenColors("24-bits");

		// then
		assertThat(resultingSystemInfo).isSameAs(systemInfo);
		assertThat(systemInfo.getScreenColors()).isEqualTo("24-bits");
	}
}
