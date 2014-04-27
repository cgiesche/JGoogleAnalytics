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

import de.perdoctus.jga.payload.segments.ContentInformation;
import org.junit.Test;

import static de.perdoctus.jga.assertj.EnrichedAssertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class PageViewTest {

	@Test
	public void testHitType() throws Exception {
		// when
		final PageView pageView = new PageView();

		// then
		assertThat(pageView.getHitType()).isEqualTo(Payload.HitType.PAGEVIEW);

		assertThat(pageView).hasHitType(Payload.HitType.PAGEVIEW);
	}

	@Test
	public void testConstructorWithContentInfo() throws Exception {
		// given
		final String documentLocation = "http://foo.com/home?a=b";
		final String documentTitle = "Settings";
		final ContentInformation contentInformation = new ContentInformation(documentLocation, documentTitle);

		// when
		final PageView pageView = new PageView(contentInformation);

		// then
		assertThat(pageView.getHitType()).isEqualTo(Payload.HitType.PAGEVIEW);
		assertThat(pageView.getContentInformation()).isSameAs(contentInformation);

		assertThat(pageView).hasHitType(Payload.HitType.PAGEVIEW);
		assertThat(pageView).contains(AnalyticsParamNames.KEY_DOCUMENT_LOCATION, documentLocation);
		assertThat(pageView).contains(AnalyticsParamNames.KEY_DOCUMENT_TITLE, documentTitle);
	}
}
