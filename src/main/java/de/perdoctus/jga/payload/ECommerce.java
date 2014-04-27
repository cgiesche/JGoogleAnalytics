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

import java.util.Currency;

/**
 * @author Christoph Giesche
 */
public abstract class ECommerce<T extends ECommerce> extends Payload<T> {

	@AnalyticsParameter(AnalyticsParamNames.TRANSACTION_ID)
	private final String transactionId;
	@AnalyticsParameter(AnalyticsParamNames.CURRENCY)
	private Currency currency;

	protected ECommerce(final HitType hitType, final String transactionId) {
		super(hitType);
		this.transactionId = transactionId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	@SuppressWarnings("unchecked")
	public T currency(final Currency currency) {
		this.currency = currency;
		return (T) this;
	}

	public Currency getCurrency() {
		return currency;
	}
}
