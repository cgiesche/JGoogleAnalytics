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

import com.sun.istack.internal.Nullable;
import de.perdoctus.jga.annotation.AnalyticsParameter;
import de.perdoctus.jga.annotation.Embedded;
import de.perdoctus.jga.payload.segments.AppInfo;
import de.perdoctus.jga.payload.segments.ContentExperiment;
import de.perdoctus.jga.payload.segments.ContentInformation;
import de.perdoctus.jga.payload.segments.Session;
import de.perdoctus.jga.payload.types.BooleanValue;

/**
 * @author Christoph Giesche
 */
public abstract class Payload<T extends Payload> {

	public static final String UNCHECKED = "unchecked";

	@AnalyticsParameter(AnalyticsParamNames.HITTYPE)
	private final HitType hitType;
	@AnalyticsParameter(AnalyticsParamNames.HITTYPE_NONINTERACTIVE)
	private BooleanValue nonInteractive;
	@AnalyticsParameter(AnalyticsParamNames.ANONYMIZE_IP)
	private BooleanValue anonymizeIP;
	@AnalyticsParameter(AnalyticsParamNames.QUEUE_TIME)
	private Integer queueTime;
	@Embedded
	private ContentInformation contentInformation;
	@Embedded
	private AppInfo appInfo;
	@Embedded
	private ContentExperiment contentExperiment;
	@Embedded
	private Session session;

	protected Payload(final HitType hitType) {
		this.hitType = hitType;
	}

	/**
	 * Specifies that a hit be considered non-interactive.
	 * <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ni">Non-Interaction Hit</a>
	 */
	@SuppressWarnings(UNCHECKED)
	public T nonInteractive(final boolean nonInteractive) {
		this.nonInteractive = BooleanValue.valueOf(nonInteractive);
		return (T) this;
	}

	/**
	 * When present, the IP address of the sender will be anonymized.
	 *
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#aip">Anonymize IP</a>
	 */
	@SuppressWarnings("unchecked")
	public T anonymizeIP(final boolean anonymizeIp) {
		this.anonymizeIP = BooleanValue.valueOf(anonymizeIp);
		return (T) this;
	}

	/**
	 * @param milliseconds Used to collect offline / latent hits. The value represents the time delta (in milliseconds) between when the hit being reported occurred and the time the hit was sent. The value must be greater than or equal to 0. Values greater than four hours may lead to hits not being processed.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#qt">Queue Time</a>
	 */
	@SuppressWarnings(UNCHECKED)
	public T queueTime(final int milliseconds) {
		this.queueTime = milliseconds;
		return (T) this;
	}

	@SuppressWarnings(UNCHECKED)
	public T with(final ContentInformation contentInformation) {
		this.contentInformation = contentInformation;
		return (T) this;
	}

	@SuppressWarnings(UNCHECKED)
	public T with(final AppInfo appInfo) {
		this.appInfo = appInfo;
		return (T) this;
	}

	@SuppressWarnings(UNCHECKED)
	public T with(final ContentExperiment contentExperiment) {
		this.contentExperiment = contentExperiment;
		return (T) this;
	}

	@SuppressWarnings(UNCHECKED)
	public T with(final Session session) {
		this.session = session;
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

	public Session getSession() {
		return session;
	}

	public boolean getNonInteractive() {
		return nonInteractive.toBoolean();
	}

	public boolean isAnonymizeIP() {
		return anonymizeIP.toBoolean();
	}

	public Integer getQueueTime() {
		return queueTime;
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
