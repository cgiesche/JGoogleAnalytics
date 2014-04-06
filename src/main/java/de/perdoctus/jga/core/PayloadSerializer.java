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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Christoph Giesche
 */
public class PayloadSerializer {

	public static final char SEPARATOR_CHAR = '&';
	public static final String EMPTY_STRING = "";
	private final static Logger LOG = LoggerFactory.getLogger(PayloadSerializer.class);
	private final AnalyticsParamResolver analyticsParamResolver = new AnalyticsParamResolver();

	public String serialize(final Object content) {
		if (content == null) {
			return EMPTY_STRING;
		}

		boolean addSeparator = false;
		final StringBuilder stringBuilder = new StringBuilder();

		final List<AnalyticsField> analyticsFields = analyticsParamResolver.getAnalyticsParamFields(content.getClass());

		for (final AnalyticsField analyticsField : analyticsFields) {
			final String paramExpression;
			if (analyticsField instanceof ParameterField) {
				paramExpression = evaluateParam((ParameterField) analyticsField, content);
			} else if (analyticsField instanceof EmbeddedField) {
				final Object embeddedObject = getFieldValue(analyticsField.getField(), content);
				paramExpression = serialize(embeddedObject);
			} else {
				LOG.error("Got unknown AnalyticsField of type " + analyticsField.getClass().getSimpleName());
				paramExpression = null;
			}

			if (paramExpression != null && !paramExpression.isEmpty()) {
				if (addSeparator) {
					stringBuilder.append(SEPARATOR_CHAR);
				} else {
					addSeparator = true;
				}
				stringBuilder.append(paramExpression);
			}
		}

		return stringBuilder.toString();
	}

	private String evaluateParam(final ParameterField parameterField, final Object content) {
		String paramExpression = null;
		final Field annotatedField = parameterField.getField();
		final AnalyticsParameter fieldAnnotation = parameterField.getParameterAnnotation();
		final String parameterKey = fieldAnnotation.value();

		final Object fieldValue = getFieldValue(annotatedField, content);
		if (fieldValue != null || fieldAnnotation.forceParam()) {
			paramExpression = parameterKey + '=' + String.valueOf(fieldValue);
		}

		return paramExpression;
	}

	private Object getFieldValue(final Field field, final Object object) {
		Object fieldValue;

		try {
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}

			fieldValue = field.get(object);
		} catch (Exception e) {
			LOG.error("Failed to get value of field.", e);
			fieldValue = null;
		}

		return fieldValue;
	}

}
