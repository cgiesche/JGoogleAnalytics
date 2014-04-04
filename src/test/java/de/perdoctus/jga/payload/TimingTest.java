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
public class TimingTest {

	@Test
	public void testConstructor() throws Exception {
		// when
		final Timing timing = new Timing();

		// then
		assertThat(timing).isNotNull();
		assertThat(timing.getHitType()).isEqualTo(Payload.HitType.TIMING);
	}

	@Test
	public void testUserTimingCategory() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final String userTimingCategory = "category";
		final Timing resultingTiming = timing.userTimingCategory(userTimingCategory);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getUserTimingCategory()).isEqualTo(userTimingCategory);
	}

	@Test
	public void testUserTimingVariableName() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final String userTimingVariable = "lookup";
		final Timing resultingTiming = timing.userTimingVariable(userTimingVariable);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getUserTimingVariable()).isEqualTo(userTimingVariable);
	}

	@Test
	public void testUserTimingTime() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final Integer userTimingTime = 123;
		final Timing resultingTiming = timing.userTimingTime(userTimingTime);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getUserTimingTime()).isEqualTo(userTimingTime);
	}

	@Test
	public void testUserTimingLabel() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final String userTimingLabel = "label";
		final Timing resultingTiming = timing.userTimingLabel(userTimingLabel);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getUserTimingLabel()).isEqualTo(userTimingLabel);
	}

	@Test
	public void testPageLoadTime() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final Integer pageLoadTime = 3554;
		final Timing resultingTiming = timing.pageLoadTime(pageLoadTime);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getPageLoadTime()).isEqualTo(pageLoadTime);
	}

	@Test
	public void testDNSTime() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final Integer dnsTime = 500;
		final Timing resultingTiming = timing.dnsTime(dnsTime);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getDnsTime()).isEqualTo(dnsTime);
	}

	@Test
	public void testPageDownloadTime() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final Integer pageDownloadTime = 500;
		final Timing resultingTiming = timing.pageDownloadTime(pageDownloadTime);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getPageDownloadTime()).isEqualTo(pageDownloadTime);
	}

	@Test
	public void testRedirectResponseTime() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final Integer redirectResponseTime = 500;
		final Timing resultingTiming = timing.redirectResponseTime(redirectResponseTime);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getRedirectResponseTime()).isEqualTo(redirectResponseTime);
	}

	@Test
	public void testTcpConnectTime() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final Integer tcpConnectTime = 500;
		final Timing resultingTiming = timing.tcpConnectTime(tcpConnectTime);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getTcpConnectTime()).isEqualTo(tcpConnectTime);
	}

	@Test
	public void testServerResponseTime() throws Exception {
		// given
		final Timing timing = new Timing();

		// when
		final Integer serverResponseTime = 500;
		final Timing resultingTiming = timing.serverResponseTime(serverResponseTime);

		// then
		assertThat(resultingTiming).isSameAs(timing);
		assertThat(resultingTiming.getServerResponseTime()).isEqualTo(serverResponseTime);
	}
}
