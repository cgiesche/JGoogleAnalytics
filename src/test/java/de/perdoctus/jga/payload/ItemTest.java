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
public class ItemTest {

	@Test
	public void testConstructor() throws Exception {
		// when
		final Item item = new Item("TAID", "FooItem");

		// then
		assertThat(item).isNotNull();
		assertThat(item.getTransactionId()).isEqualTo("TAID");
		assertThat(item.getItemName()).isEqualTo("FooItem");
	}

	@Test
	public void testPrice() throws Exception {
		// given
		final Item item = new Item("TAID", "FooItem");

		// when
		final CurrencyValue currencyValue = new CurrencyValue(2.99F);
		final Item resultingItem = item.price(currencyValue);

		// then
		assertThat(resultingItem).isSameAs(item);
		assertThat(item.getPrice()).isEqualTo(currencyValue);
	}

	@Test
	public void testQuantity() throws Exception {
		// given
		final Item item = new Item("TAID", "FooItem");

		// when
		final Item resultingItem = item.quantity(2);

		// then
		assertThat(resultingItem).isSameAs(item);
		assertThat(item.getQuantity()).isEqualTo(2);
	}

	@Test
	public void testCode() throws Exception {
		// given
		final Item item = new Item("TAID", "FooItem");

		// when
		final String itemCode = "SKU47";
		final Item resultingItem = item.code(itemCode);

		// then
		assertThat(resultingItem).isSameAs(item);
		assertThat(item.getCode()).isEqualTo(itemCode);
	}

	@Test
	public void testCategory() throws Exception {
		// given
		final Item item = new Item("TAID", "FooItem");

		// when
		final String category = "Blue";
		final Item resultingItem = item.category(category);

		// then
		assertThat(resultingItem).isSameAs(item);
		assertThat(item.getCategory()).isEqualTo(category);
	}
}
