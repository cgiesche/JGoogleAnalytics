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

import de.perdoctus.jga.payload.types.CurrencyValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class TransactionTest {

	@Test
	public void testConstructor() throws Exception {
		// when
		final Transaction transaction = new Transaction("TAID");

		// then
		assertThat(transaction).isNotNull();
		assertThat(transaction.getHitType()).isEqualTo(Payload.HitType.TRANSACTION);
		assertThat(transaction.getTransactionId()).isEqualTo("TAID");
	}

	@Test
	public void testAffiliation() throws Exception {
		// given
		final Transaction transaction = new Transaction("TAID");

		// when
		final Transaction resultingTransaction = transaction.affiliation("Member");

		// then
		assertThat(resultingTransaction).isSameAs(transaction);
		assertThat(transaction.getAffiliation()).isEqualTo("Member");
	}

	@Test
	public void testRevenue() throws Exception {
		// given
		final Transaction transaction = new Transaction("TAID");

		// when
		final CurrencyValue revenue = new CurrencyValue(1.22F);
		final Transaction resultingTransaction = transaction.revenue(revenue);

		// then
		assertThat(resultingTransaction).isSameAs(transaction);
		assertThat(transaction.getRevenue()).isEqualTo(revenue);
	}

	@Test
	public void testShipping() throws Exception {
		// given
		final Transaction transaction = new Transaction("TAID");

		// when
		final CurrencyValue shipping = new CurrencyValue(1.22F);
		final Transaction resultingTransaction = transaction.shipping(shipping);

		// then
		assertThat(resultingTransaction).isSameAs(transaction);
		assertThat(transaction.getShipping()).isEqualTo(shipping);
	}

	@Test
	public void testTax() throws Exception {
		// given
		final Transaction transaction = new Transaction("TAID");

		// when
		final CurrencyValue tax = new CurrencyValue(1.22F);
		final Transaction resultingTransaction = transaction.tax(tax);

		// then
		assertThat(resultingTransaction).isSameAs(transaction);
		assertThat(transaction.getTax()).isEqualTo(tax);
	}

}
