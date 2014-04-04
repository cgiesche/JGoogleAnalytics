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

import de.perdoctus.jga.annotation.AnalyticsParameter;

/**
 * @author Christoph Giesche
 */
public class Timing extends Payload<Timing> {

	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_USERTIMING_CATEGORY)
	private String userTimingCategory;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_USERTIMING_VARIABLE)
	private String userTimingVariable;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_USERTIMING_TIME)
	private Integer userTimingTime;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_USERTIMING_LABEL)
	private String userTimingLabel;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_PAGE_LOAD_TIME)
	private Integer pageLoadTime;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_DNS_TIME)
	private Integer dnsTime;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_PAGE_DOWNLOAD_TIME)
	private Integer pageDownloadTime;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_REDIRECT_RESPONSE_TIME)
	private Integer redirectResponseTime;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_TCP_CONNECT_TIME)
	private Integer tcpConnectTime;
	@AnalyticsParameter(AnalyticsParamNames.KEY_TIMING_SERVER_RESPONSE_TIME)
	private Integer serverResponseTime;

	public Timing() {
		super(HitType.TIMING);
	}

	public Timing userTimingCategory(final String userTimingCategory) {
		this.userTimingCategory = userTimingCategory;
		return this;
	}

	public String getUserTimingCategory() {
		return userTimingCategory;
	}

	public Timing userTimingVariable(final String userTimingVariableName) {
		this.userTimingVariable = userTimingVariableName;
		return this;
	}

	public String getUserTimingVariable() {
		return userTimingVariable;
	}

	public Timing userTimingTime(final Integer userTimingTime) {
		this.userTimingTime = userTimingTime;
		return this;
	}

	public Integer getUserTimingTime() {
		return userTimingTime;
	}

	public Timing userTimingLabel(final String userTimingLabel) {
		this.userTimingLabel = userTimingLabel;
		return this;
	}

	public String getUserTimingLabel() {
		return userTimingLabel;
	}

	public Timing pageLoadTime(final Integer pageLoadTime) {
		this.pageLoadTime = pageLoadTime;
		return this;
	}

	public int getPageLoadTime() {
		return pageLoadTime;
	}

	public Timing dnsTime(final Integer dnsTime) {
		this.dnsTime = dnsTime;
		return this;
	}

	public int getDnsTime() {
		return dnsTime;
	}

	public Timing pageDownloadTime(final Integer pageDownloadTime) {
		this.pageDownloadTime = pageDownloadTime;
		return this;
	}

	public Integer getPageDownloadTime() {
		return pageDownloadTime;
	}

	public Timing redirectResponseTime(final Integer redirectResponseTime) {
		this.redirectResponseTime = redirectResponseTime;
		return this;
	}

	public Integer getRedirectResponseTime() {
		return redirectResponseTime;
	}

	public Timing tcpConnectTime(final Integer tcpConnectTime) {
		this.tcpConnectTime = tcpConnectTime;
		return this;
	}

	public Integer getTcpConnectTime() {
		return tcpConnectTime;
	}

	public Timing serverResponseTime(final Integer serverResponseTime) {
		this.serverResponseTime = serverResponseTime;
		return this;
	}

	public Integer getServerResponseTime() {
		return serverResponseTime;
	}
}
