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
import de.perdoctus.jga.payload.types.CurrencyValue;

/**
 * @author Christoph Giesche
 */
public class Transaction extends ECommerce<Transaction> {

	@AnalyticsParameter(AnalyticsParamNames.TRANSACTION_AFFILIATION)
	private String affiliation;
	@AnalyticsParameter(AnalyticsParamNames.TRANSACTION_REVENUE)
	private CurrencyValue revenue;
	@AnalyticsParameter(AnalyticsParamNames.TRANSACTION_SHIPPING)
	private CurrencyValue shipping;
	@AnalyticsParameter(AnalyticsParamNames.TRANSACTION_TAX)
	private CurrencyValue tax;

	public Transaction(final String transactionId) {
		super(HitType.TRANSACTION, transactionId);
	}

	public Transaction affiliation(final String affiliation) {
		this.affiliation = affiliation;
		return this;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public Transaction revenue(final CurrencyValue revenue) {
		this.revenue = revenue;
		return this;
	}

	public CurrencyValue getRevenue() {
		return revenue;
	}

	public Transaction shipping(final CurrencyValue shipping) {
		this.shipping = shipping;
		return this;
	}

	public CurrencyValue getShipping() {
		return shipping;
	}

	public Transaction tax(final CurrencyValue tax) {
		this.tax = tax;
		return this;
	}

	public CurrencyValue getTax() {
		return tax;
	}
}
