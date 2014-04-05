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
import de.perdoctus.jga.payload.types.BooleanValue;

/**
 * @author Christoph Giesche
 */
public class AnalyticsException extends Payload<AnalyticsException> {

	@AnalyticsParameter(AnalyticsParamNames.KEY_EXCEPTION_DESCRIPTION)
	private String description;
	@AnalyticsParameter(AnalyticsParamNames.KEY_EXCEPTION_FATAL)
	private BooleanValue fatal;

	public AnalyticsException() {
		super(HitType.EXCEPTION);
	}

	public AnalyticsException(final Exception exception) {
		this();
		description(exception.getClass().getSimpleName());
	}

	public AnalyticsException description(final String description) {
		this.description = description;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public AnalyticsException fatal(final BooleanValue fatal) {
		this.fatal = fatal;
		return this;
	}

	public BooleanValue getFatal() {
		return fatal;
	}
}
