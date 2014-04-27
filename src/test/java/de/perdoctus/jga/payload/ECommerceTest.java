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

import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static de.perdoctus.jga.assertj.EnrichedAssertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class ECommerceTest {

	@Test
	public void testConstructor() throws Exception {
		// given
		final String transactionId = "TAID";

		// when
		final ECommerce eCommerce = new ECommerce(Payload.HitType.TRANSACTION, transactionId) {
		};

		// then
		assertThat(eCommerce).isNotNull();
		assertThat(eCommerce.getTransactionId()).isEqualTo(transactionId);

		assertThat(eCommerce).contains(AnalyticsParamNames.KEY_TRANSACTION_ID, transactionId);
	}

	@Test
	public void testCurrency() throws Exception {
		// given
		final String transactionId = "TAID";
		final Currency currency = Currency.getInstance(Locale.GERMANY);
		final ECommerce eCommerce = new ECommerce(Payload.HitType.TRANSACTION, transactionId) {
		};

		// when
		final ECommerce resultingTransaction = eCommerce.currency(currency);

		// then
		assertThat(resultingTransaction).isSameAs(eCommerce);
		assertThat(eCommerce.getCurrency()).isEqualTo(currency);

		assertThat(eCommerce).contains(AnalyticsParamNames.KEY_TRANSACTION_ID, transactionId);
		assertThat(eCommerce).contains(AnalyticsParamNames.KEY_CURRENCY, currency.getCurrencyCode());
	}
}
