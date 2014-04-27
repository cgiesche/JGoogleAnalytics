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

import static de.perdoctus.jga.assertj.EnrichedAssertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class ItemTest {

	@Test
	public void testConstructor() throws Exception {
		// given
		final String itemName = "FooItem";
		final String transactionId = "TAID";

		// when
		final Item item = new Item(transactionId, itemName);

		// then
		assertThat(item).isNotNull();
		assertThat(item.getTransactionId()).isEqualTo(transactionId);
		assertThat(item.getItemName()).isEqualTo(itemName);

		assertThat(item).hasHitType(Payload.HitType.ITEM);
		assertThat(item).contains(AnalyticsParamNames.TRANSACTION_ID, transactionId);
		assertThat(item).contains(AnalyticsParamNames.ITEM_NAME, itemName);
	}

	@Test
	public void testPrice() throws Exception {
		// given
		final String transactionId = "TAID";
		final String itemName = "FooItem";
		final Item item = new Item(transactionId, itemName);
		final CurrencyValue currencyValue = new CurrencyValue(2.99F);

		// when
		final Item resultingItem = item.price(currencyValue);

		// then
		assertThat(resultingItem).isSameAs(item);
		assertThat(item.getPrice()).isEqualTo(currencyValue);

		assertThat(item).hasHitType(Payload.HitType.ITEM);
		assertThat(item).contains(AnalyticsParamNames.TRANSACTION_ID, transactionId);
		assertThat(item).contains(AnalyticsParamNames.ITEM_NAME, itemName);
		assertThat(item).contains(AnalyticsParamNames.ITEM_PRICE, currencyValue);
	}

	@Test
	public void testQuantity() throws Exception {
		// given
		final String transactionId = "TAID";
		final String itemName = "FooItem";
		final Item item = new Item(transactionId, itemName);
		final int quantity = 2;

		// when
		final Item resultingItem = item.quantity(quantity);

		// then
		assertThat(resultingItem).isSameAs(item);
		assertThat(item.getQuantity()).isEqualTo(quantity);

		assertThat(item).hasHitType(Payload.HitType.ITEM);
		assertThat(item).contains(AnalyticsParamNames.TRANSACTION_ID, transactionId);
		assertThat(item).contains(AnalyticsParamNames.ITEM_NAME, itemName);
		assertThat(item).contains(AnalyticsParamNames.ITEM_QUANTITY, quantity);
	}

	@Test
	public void testCode() throws Exception {
		// given
		final String transactionId = "TAID";
		final String itemName = "FooItem";
		final Item item = new Item(transactionId, itemName);
		final String itemCode = "SKU47";

		// when
		final Item resultingItem = item.code(itemCode);

		// then
		assertThat(resultingItem).isSameAs(item);
		assertThat(item.getCode()).isEqualTo(itemCode);

		assertThat(item).hasHitType(Payload.HitType.ITEM);
		assertThat(item).contains(AnalyticsParamNames.TRANSACTION_ID, transactionId);
		assertThat(item).contains(AnalyticsParamNames.ITEM_NAME, itemName);
		assertThat(item).contains(AnalyticsParamNames.ITEM_CODE, itemCode);
	}

	@Test
	public void testCategory() throws Exception {
		// given
		final String transactionId = "TAID";
		final String itemName = "FooItem";
		final Item item = new Item(transactionId, itemName);
		final String category = "Blue";

		// when
		final Item resultingItem = item.category(category);

		// then
		assertThat(resultingItem).isSameAs(item);
		assertThat(item.getCategory()).isEqualTo(category);

		assertThat(item).hasHitType(Payload.HitType.ITEM);
		assertThat(item).contains(AnalyticsParamNames.TRANSACTION_ID, transactionId);
		assertThat(item).contains(AnalyticsParamNames.ITEM_NAME, itemName);
		assertThat(item).contains(AnalyticsParamNames.ITEM_CATEGORY, category);
	}
}
