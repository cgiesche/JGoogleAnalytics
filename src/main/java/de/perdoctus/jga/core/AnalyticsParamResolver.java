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

package de.perdoctus.jga.core;

import de.perdoctus.jga.annotation.AnalyticsParameter;
import de.perdoctus.jga.annotation.Embedded;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Christoph Giesche
 */
public class AnalyticsParamResolver {

	private Map<Class, List<AnalyticsField>> cache = new HashMap<>();

	public List<AnalyticsField> getAnalyticsParamFields(final Class clazz) {
		if (!cache.containsKey(clazz)) {
			final List<Field> declaredFields = getAllDeclaredFields(clazz);
			cache.put(clazz, getAnalyticsParamFields(declaredFields));
		}

		return cache.get(clazz);
	}

	private List<Field> getAllDeclaredFields(final Class clazz) {
		final List<Field> declaredFields = new LinkedList<>();
		declaredFields.addAll(Arrays.asList(clazz.getDeclaredFields()));

		final Class superclass = clazz.getSuperclass();
		if (superclass != null) {
			declaredFields.addAll(getAllDeclaredFields(superclass));
		}

		return declaredFields;
	}

	private List<AnalyticsField> getAnalyticsParamFields(final List<Field> declaredFields) {
		final List<AnalyticsField> parameterFields = new LinkedList<>();

		for (final Field declaredField : declaredFields) {
			final AnalyticsParameter analyticsParameter = declaredField.getAnnotation(AnalyticsParameter.class);
			if (analyticsParameter != null) {
				parameterFields.add(new ParameterField(analyticsParameter, declaredField));
			}
			final Embedded embedded = declaredField.getAnnotation(Embedded.class);
			if (embedded != null) {
				parameterFields.add(new EmbeddedField(declaredField));
			}
		}

		return parameterFields;
	}

}
