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
import de.perdoctus.jga.annotation.Embedded;
import de.perdoctus.jga.payload.segments.AppInfo;
import de.perdoctus.jga.payload.segments.ContentExperiment;
import de.perdoctus.jga.payload.segments.ContentInformation;

/**
 * @author Christoph Giesche
 */
public abstract class Payload<T extends Payload> {

	public static final String UNCHECKED = "unchecked";
	public static final String KEY_QUEUE_TIME = "qt";

	@AnalyticsParameter(AnalyticsParamNames.KEY_HITTYPE)
	private final HitType hitType;
	@AnalyticsParameter(AnalyticsParamNames.KEY_HITTYPE_NONINTERACTIVE)
	private Integer nonInteractive;
	@AnalyticsParameter(AnalyticsParamNames.KEY_ANONYMIZE_IP)
	private Integer anonymizeIP;
	@AnalyticsParameter(KEY_QUEUE_TIME)
	private Integer queueTime;
	@Embedded
	private ContentInformation contentInformation;
	@Embedded
	private AppInfo appInfo;
	@Embedded
	private ContentExperiment contentExperiment;

	protected Payload(final HitType hitType) {
		this.hitType = hitType;
	}

	/**
	 * Specifies that a hit be considered non-interactive.
	 * <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ni">Non-Interaction Hit</a>
	 */
	@SuppressWarnings(UNCHECKED)
	public T nonInteractive() {
		this.nonInteractive = 1;
		return (T) this;
	}

	/**
	 * When present, the IP address of the sender will be anonymized.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#aip">Anonymize IP</a>
	 */
	@SuppressWarnings("unchecked")
	public T anonymizeIP() {
		this.anonymizeIP = 1;
		return (T) this;
	}

	/**
	 * @param milliseconds Used to collect offline / latent hits. The value represents the time delta (in milliseconds) between when the hit being reported occurred and the time the hit was sent. The value must be greater than or equal to 0. Values greater than four hours may lead to hits not being processed.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#qt">Queue Time</a>
	 */
	@SuppressWarnings(UNCHECKED)
	public Payload queueTime(int milliseconds) {
		this.queueTime = milliseconds;
		return (T) this;
	}

	@SuppressWarnings(UNCHECKED)
	public T with(final ContentInformation contentInformation) {
		this.contentInformation = contentInformation;
		return (T) this;
	}

	@SuppressWarnings(UNCHECKED)
	public Payload with(final AppInfo appInfo) {
		this.appInfo = appInfo;
		return (T) this;
	}

	@SuppressWarnings(UNCHECKED)
	public Payload with(final ContentExperiment contentExperiment) {
		this.contentExperiment = contentExperiment;
		return (T) this;
	}

	public ContentInformation getContentInformation() {
		return contentInformation;
	}

	public AppInfo getAppInfo() {
		return appInfo;
	}

	public ContentExperiment getContentExperiment() {
		return contentExperiment;
	}

	public HitType getHitType() {
		return hitType;
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
		TIMING;

		@Override
		public String toString() {
			return name().toLowerCase();
		}
	}
}
