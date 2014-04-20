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

package de.perdoctus.jga.payload.segments;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class ContentExperimentTest {

	@Test
	public void testExperimentId() throws Exception {
		// given
		final ContentExperiment contentExperiment = new ContentExperiment();
		final String experimentId = "Qp0gahJ3RAO3DJ18b0XoUQ";

		// when
		final ContentExperiment resultingContentExperiment = contentExperiment.id(experimentId);

		// then
		assertThat(resultingContentExperiment).isSameAs(contentExperiment);
		assertThat(contentExperiment.getId()).isEqualTo(experimentId);
	}

	@Test
	public void testExperimentVariant() throws Exception {
		// given
		final ContentExperiment contentExperiment = new ContentExperiment();
		final String variant = "1";

		// when
		final ContentExperiment resultingContentExperiment = contentExperiment.variant(variant);

		// then
		assertThat(resultingContentExperiment).isSameAs(contentExperiment);
		assertThat(contentExperiment.getVariant()).isEqualTo(variant);

	}

	@Test
	public void testParamConstructor() throws Exception {
		// given
		final String experimentId = "Qp0gahJ3RAO3DJ18b0XoUQ";
		final String variant = "1";

		// when
		final ContentExperiment contentExperiment = new ContentExperiment(experimentId, variant);

		// then
		assertThat(contentExperiment.getId()).isEqualTo(experimentId);
		assertThat(contentExperiment.getVariant()).isEqualTo(variant);

	}
}
