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
public class Item extends ECommerce<Item> {

	@AnalyticsParameter(AnalyticsParamNames.ITEM_NAME)
	private final String itemName;
	@AnalyticsParameter(AnalyticsParamNames.ITEM_PRICE)
	private CurrencyValue price;
	@AnalyticsParameter(AnalyticsParamNames.ITEM_QUANTITY)
	private Integer quantity;
	@AnalyticsParameter(AnalyticsParamNames.ITEM_CODE)
	private String code;
	@AnalyticsParameter(AnalyticsParamNames.ITEM_CATEGORY)
	private String category;

	public Item(final String transactionId, final String itemName) {
		super(HitType.ITEM, transactionId);
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public Item price(final CurrencyValue price) {
		this.price = price;
		return this;
	}

	public CurrencyValue getPrice() {
		return price;
	}

	public Item quantity(final int quantity) {
		this.quantity = quantity;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public Item code(final String code) {
		this.code = code;
		return this;
	}

	public String getCode() {
		return code;
	}

	public Item category(final String category) {
		this.category = category;
		return this;
	}

	public String getCategory() {
		return category;
	}
}
