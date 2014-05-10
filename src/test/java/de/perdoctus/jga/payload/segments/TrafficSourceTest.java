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
public class TrafficSourceTest {

	@Test
	public void testDocumentReferrer() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String referrer = "http://example.com";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.documentReferrer(referrer);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getDocumentReferrer()).isEqualTo(referrer);

	}

	@Test
	public void testCampaignName() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String campaignName = "(direct)";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.campaignName(campaignName);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getCampaignName()).isEqualTo(campaignName);

	}

	@Test
	public void testCampaignSource() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String campaignSource = "(direct)";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.campaignSource(campaignSource);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getCampaignSource()).isEqualTo(campaignSource);

	}

	@Test
	public void testCampaignMedium() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String campaignMedium = "organic";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.campaignMedium(campaignMedium);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getCampaignMedium()).isEqualTo(campaignMedium);

	}

	@Test
	public void testCampaignKeyword() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String campaignKeyword = "Blue Shoes";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.campaignKeyword(campaignKeyword);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getCampaignKeyword()).isEqualTo(campaignKeyword);

	}

	@Test
	public void testCampaignContent() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String campaignContent = "content";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.campaignContent(campaignContent);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getCampaignContent()).isEqualTo(campaignContent);

	}

	@Test
	public void testCampaignId() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String campaignId = "ID";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.campaignId(campaignId);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getCampaignId()).isEqualTo(campaignId);

	}

	@Test
	public void testAdWordsId() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String googleAdWordsId = "CL6Q-OXyqKUCFcgK2goddQuoHg";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.adWordsId(googleAdWordsId);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getAdWordsId()).isEqualTo(googleAdWordsId);

	}

	@Test
	public void testDisplayAdsId() throws Exception {
		// given
		final TrafficSource trafficSource = new TrafficSource();
		final String googleDisplayAdsId = "d_click_id";

		// when
		final TrafficSource resultingTrafficSource = trafficSource.displayAdsId(googleDisplayAdsId);

		// then
		assertThat(resultingTrafficSource).isSameAs(trafficSource);
		assertThat(trafficSource.getDisplayAdsId()).isEqualTo(googleDisplayAdsId);

	}
}
