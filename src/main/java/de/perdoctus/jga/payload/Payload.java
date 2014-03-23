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

import de.perdoctus.jga.payload.segments.ContentInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Christoph Giesche
 */
public class Payload<T extends Payload> {

	public static final String KEY_PROTOCOL_VERSION = "v";
	public static final String KEY_DOCUMENT_LOCATION = "dl";
	public static final String KEY_DOCUMENT_HOST_NAME = "dh";
	public static final String KEY_HITTYPE = "t";
	public static final String KEY_DOCUMENT_PATH = "dp";
	public static final String KEY_DOCUMENT_TITLE = "dt";
	public static final String KEY_HITTYPE_NONINTERACTIVE = "ni";
	public static final String KEY_TRACKING_ID = "tid";
	public static final String KEY_CLIENT_ID = "cid";
	public static final String KEY_ANONYMIZE_IP = "aip";
	private static final Logger LOG = LoggerFactory.getLogger(Payload.class);
	private final Map<String, String> payloadData = new HashMap<>();

	protected Payload(final HitType hitType) {
		payloadData.put(KEY_HITTYPE, hitType.name().toLowerCase());
	}

	public void addParameter(final String parameterName, final String parameterValue) {
		if (parameterValue != null && !parameterValue.isEmpty()) {
			payloadData.put(parameterName, parameterValue);
		}
	}

	/**
	 * Specifies that a hit be considered non-interactive.
	 * <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ni">Non-Interaction Hit</a>
	 */
	@SuppressWarnings("unchecked")
	public T nonInteractive() {
		addParameter(KEY_HITTYPE_NONINTERACTIVE, "1");
		return (T) this;
	}

	/**
	 * <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#content">Content Information</a>
	 */
	@SuppressWarnings("unchecked")
	public T contentInformation(final ContentInformation contentInformation) {
		addParameter(KEY_DOCUMENT_HOST_NAME, contentInformation.getDocumentHostName());
		addParameter(KEY_DOCUMENT_LOCATION, contentInformation.getDocumentLocation());
		addParameter(KEY_DOCUMENT_PATH, contentInformation.getDocumentPath());
		addParameter(KEY_DOCUMENT_TITLE, contentInformation.getDocumentTitle());
		return (T) this;
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder(payloadData.size() * 8);
		boolean firstEntry = true;

		for (Map.Entry<String, String> entry : payloadData.entrySet()) {
			if (firstEntry) {
				firstEntry = false;
			} else {
				stringBuilder.append('&');
			}
			try {
				final String encodedValue = URLEncoder.encode(entry.getValue(), "UTF-8");
				stringBuilder.append(entry.getKey()).append("=").append(encodedValue);
			} catch (UnsupportedEncodingException e) {
				LOG.error("Failed to URLEncode " + entry.getValue(), e);
			}
		}

		return stringBuilder.toString();
	}

	/**
	 * When present, the IP address of the sender will be anonymized.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#aip">Anonymize IP</a>
	 */
	public void anonymizeIP() {
		addParameter(KEY_ANONYMIZE_IP, "1");
	}

	/**
	 * @author Christoph Giesche
	 */
	public static enum HitType {
		PAGEVIEW,
		APPVIEW,
		EVENT,
		TRANSACTION,
		ITEM,
		SOCIAL,
		EXCEPTION,
		TIMING
	}
}
