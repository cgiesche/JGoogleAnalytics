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

/**
 * @author Christoph Giesche
 */
public final class AnalyticsParamNames {

	/* General */
	public static final String KEY_HITTYPE = "t";
	public static final String KEY_HITTYPE_NONINTERACTIVE = "ni";
	public static final String KEY_ANONYMIZE_IP = "aip";
	public static final String KEY_SESSION_CONTROL = "sc";

	/* Event Tracking */
	public static final String KEY_EVENT_CATEGORY = "ec";
	public static final String KEY_EVENT_ACTION = "ea";
	public static final String KEY_EVENT_LABEL = "el";
	public static final String KEY_EVENT_VALUE = "ev";

	/* Content Information */
	public static final String KEY_DOCUMENT_LOCATION = "dl";
	public static final String KEY_DOCUMENT_HOST_NAME = "dh";
	public static final String KEY_DOCUMENT_PATH = "dp";
	public static final String KEY_DOCUMENT_TITLE = "dt";
	public static final String KEY_CONTENT_DESCRIPTION = "cd";
	public static final String KEY_LINK_ID = "linkid";

	/* E-Commerce (Transaction & Item) */
	public static final String KEY_TRANSACTION_ID = "ti";

	/* Transaction */
	public static final String KEY_TRANSACTION_AFFILIATION = "ta";
	public static final String KEY_TRANSACTION_REVENUE = "tr";
	public static final String KEY_TRANSACTION_SHIPPING = "ts";
	public static final String KEY_TRANSACTION_TAX = "tt";
	public static final String KEY_CURRENCY = "cu";

	/* App Info */
	public static final String KEY_APPLICATION_NAME = "an";
	public static final String KEY_APPLICATION_VERSION = "av";

	/* System Info */
	public static final String KEY_SCREEN_RESOLUTION = "sr";
	public static final String KEY_VIEWPORT_SIZE = "vp";
	public static final String KEY_DOCUMENT_ENCODING = "de";
	public static final String KEY_SCREEN_COLORS = "sd";
	public static final String KEY_USER_LANGUAGE = "ul";
	public static final String KEY_JAVA_ENABLED = "je";
	public static final String KEY_FLASH_VERSION = "fl";

	/* Timing */
	public static final String KEY_TIMING_USERTIMING_CATEGORY = "utc";
	public static final String KEY_TIMING_USERTIMING_VARIABLE = "utv";
	public static final String KEY_TIMING_USERTIMING_TIME = "utt";
	public static final String KEY_TIMING_USERTIMING_LABEL = "utl";
	public static final String KEY_TIMING_PAGE_LOAD_TIME = "plt";
	public static final String KEY_TIMING_DNS_TIME = "dns";
	public static final String KEY_TIMING_PAGE_DOWNLOAD_TIME = "pdt";
	public static final String KEY_TIMING_REDIRECT_RESPONSE_TIME = "rrt";
	public static final String KEY_TIMING_TCP_CONNECT_TIME = "tcp";
	public static final String KEY_TIMING_SERVER_RESPONSE_TIME = "srt";
}
