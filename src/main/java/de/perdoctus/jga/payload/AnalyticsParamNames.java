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

	/* Core */
	public static final String TRACKING_ID = "tid";
	public static final String PROTOCOL_VERSION = "v";
	public static final String CLIENT_ID = "cid";

	/* General */
	public static final String HITTYPE = "t";
	public static final String HITTYPE_NONINTERACTIVE = "ni";
	public static final String ANONYMIZE_IP = "aip";

	/* Session */
	public static final String SESSION_CONTROL = "sc";
	public static final String SESSION_IP_OVERRIDE = "uip";
	public static final String SESSION_USER_AGENT_OVERRIDE = "ua";

	/* Event Tracking */
	public static final String EVENT_CATEGORY = "ec";
	public static final String EVENT_ACTION = "ea";
	public static final String EVENT_LABEL = "el";
	public static final String EVENT_VALUE = "ev";

	/* Content Information */
	public static final String DOCUMENT_LOCATION = "dl";
	public static final String DOCUMENT_HOST_NAME = "dh";
	public static final String DOCUMENT_PATH = "dp";
	public static final String DOCUMENT_TITLE = "dt";
	public static final String CONTENT_DESCRIPTION = "cd";
	public static final String LINK_ID = "linkid";

	/* E-Commerce (Transaction & Item) */
	public static final String TRANSACTION_ID = "ti";
	public static final String CURRENCY = "cu";

	/* Transaction */
	public static final String TRANSACTION_AFFILIATION = "ta";
	public static final String TRANSACTION_REVENUE = "tr";
	public static final String TRANSACTION_SHIPPING = "ts";
	public static final String TRANSACTION_TAX = "tt";

	/* Item */
	public static final String ITEM_NAME = "in";
	public static final String ITEM_PRICE = "ip";
	public static final String ITEM_QUANTITY = "iq";
	public static final String ITEM_CODE = "ic";
	public static final String ITEM_CATEGORY = "iv";

	/* App Info */
	public static final String APPLICATION_NAME = "an";
	public static final String APPLICATION_VERSION = "av";

	/* System Info */
	public static final String SCREEN_RESOLUTION = "sr";
	public static final String VIEWPORT_SIZE = "vp";
	public static final String DOCUMENT_ENCODING = "de";
	public static final String SCREEN_COLORS = "sd";
	public static final String USER_LANGUAGE = "ul";
	public static final String JAVA_ENABLED = "je";
	public static final String FLASH_VERSION = "fl";

	/* Timing */
	public static final String TIMING_USERTIMING_CATEGORY = "utc";
	public static final String TIMING_USERTIMING_VARIABLE = "utv";
	public static final String TIMING_USERTIMING_TIME = "utt";
	public static final String TIMING_USERTIMING_LABEL = "utl";
	public static final String TIMING_PAGE_LOAD_TIME = "plt";
	public static final String TIMING_DNS_TIME = "dns";
	public static final String TIMING_PAGE_DOWNLOAD_TIME = "pdt";
	public static final String TIMING_REDIRECT_RESPONSE_TIME = "rrt";
	public static final String TIMING_TCP_CONNECT_TIME = "tcp";
	public static final String TIMING_SERVER_RESPONSE_TIME = "srt";

	/* Exception */
	public static final String EXCEPTION_DESCRIPTION = "exd";
	public static final String EXCEPTION_FATAL = "exf";

	/* Social */
	public static final String SOCIAL_NETWORK = "sn";
	public static final String SOCIAL_ACTION = "sa";
	public static final String SOCIAL_TARGET = "st";

	/* Experiment */
	public static final String EXPERIMENT_ID = "xid";
	public static final String EXPERIMENT_VARIANT = "xvar";

	/* Traffic Source */
	public static final String DOCUMENT_REFERRER = "dr";
	public static final String CAMPAIGN_NAME = "cn";
	public static final String CAMPAIGN_SOURCE = "cs";
	public static final String CAMPAIGN_MEDIUM = "cm";
	public static final String CAMPAIGN_KEYWORD = "ck";
	public static final String CAMPAING_CONTENT = "cc";
	public static final String CAMPAING_ID = "ci";
	public static final String GOOGLE_ADWORDS_ID = "gclid";
	public static final String GOOGLE_DISPLAY_ADS_ID = "dclid";

}
