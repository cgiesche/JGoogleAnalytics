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

import de.perdoctus.jga.annotation.AnalyticsParameter;
import de.perdoctus.jga.payload.AnalyticsParamNames;

/**
 * @author Christoph Giesche
 */
public class TrafficSource {

	@AnalyticsParameter(AnalyticsParamNames.DOCUMENT_REFERRER)
	private String documentReferrer;
	@AnalyticsParameter(AnalyticsParamNames.CAMPAIGN_NAME)
	private String campaignName;
	@AnalyticsParameter(AnalyticsParamNames.CAMPAIGN_SOURCE)
	private String campaignSource;
	@AnalyticsParameter(AnalyticsParamNames.CAMPAIGN_MEDIUM)
	private String campaignMedium;
	@AnalyticsParameter(AnalyticsParamNames.CAMPAIGN_KEYWORD)
	private String campaignKeyword;
	@AnalyticsParameter(AnalyticsParamNames.CAMPAING_CONTENT)
	private String campaignContent;
	@AnalyticsParameter(AnalyticsParamNames.CAMPAING_ID)
	private String campaignId;
	@AnalyticsParameter(AnalyticsParamNames.GOOGLE_ADWORDS_ID)
	private String adWordsId;
	@AnalyticsParameter(AnalyticsParamNames.GOOGLE_DISPLAY_ADS_ID)
	private String displayAdsId;

	/**
	 * Specifies which referral source brought traffic to a website. This value is also used to compute the traffic source. The format of this value is a URL.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dr">Document Referrer</a>
	 */
	public TrafficSource documentReferrer(final String documentReferrer) {
		this.documentReferrer = documentReferrer;
		return this;
	}

	/**
	 * Specifies the campaign name.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cn">Campaign Name</a>
	 */
	public TrafficSource campaignName(final String campaignName) {
		this.campaignName = campaignName;
		return this;
	}

	/**
	 * Specifies the campaign source.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cs">Campaign Source</a>
	 */
	public TrafficSource campaignSource(final String campaignSource) {
		this.campaignSource = campaignSource;
		return this;
	}

	/**
	 * Specifies the campaign medium.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cm">Campaign Medium</a>
	 */
	public TrafficSource campaignMedium(final String campaignMedium) {
		this.campaignMedium = campaignMedium;
		return this;
	}

	/**
	 * Specifies the campaign keyword.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ck">Campaign Keyword</a>
	 */
	public TrafficSource campaignKeyword(final String campaignKeyword) {
		this.campaignKeyword = campaignKeyword;
		return this;
	}

	/**
	 * Specifies the campaign content.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#cc">Campaign Content</a>
	 */
	public TrafficSource campaignContent(final String campaignContent) {
		this.campaignContent = campaignContent;
		return this;
	}

	/**
	 * Specifies the campaign Id.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ci">Campaign ID</a>
	 */
	public TrafficSource campaignId(final String campaignId) {
		this.campaignId = campaignId;
		return this;
	}

	/**
	 * Specifies the Google AdWords Id.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#gclid">Google AdWords Id</a>
	 */
	public TrafficSource adWordsId(final String adWordsId) {
		this.adWordsId = adWordsId;
		return this;
	}

	/**
	 * Specifies the Google Display Ads ID.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dclid">Google Display Ads ID</a>
	 */
	public TrafficSource displayAdsId(final String displayAdsId) {
		this.displayAdsId = displayAdsId;
		return this;
	}

	public String getDocumentReferrer() {
		return documentReferrer;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public String getCampaignSource() {
		return campaignSource;
	}

	public String getCampaignMedium() {
		return campaignMedium;
	}

	public String getCampaignKeyword() {
		return campaignKeyword;
	}

	public String getCampaignContent() {
		return campaignContent;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public String getAdWordsId() {
		return adWordsId;
	}

	public String getDisplayAdsId() {
		return displayAdsId;
	}
}
