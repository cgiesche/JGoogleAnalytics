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

package de.perdoctus.jga;

import de.perdoctus.jga.payload.Event;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicStatusLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.configuration.GlobalConfiguration.validate;

/**
 * @author Christoph Giesche
 */
@RunWith(MockitoJUnitRunner.class)
public class CollectorTest {

	@Mock
	private HttpClient httpClientMock;

	@Test
	public void testConstruct() throws Exception {
		// given
		final Configuration configuration = ConfigurationBuilder.httpEndpoint("12345").build();

		// when
		final Collector collector = new Collector(configuration);

		// then
		assertThat(collector.getConfiguration()).isEqualTo(configuration);
		assertThat(collector.getHttpClient()).isNotNull();
	}

	@Test
	public void testCollectEvent() throws Exception {
		// given
		final Configuration configuration = ConfigurationBuilder.httpEndpoint("12345").build();
		final Collector collector = new Collector(configuration, httpClientMock);

		final HttpResponse httpResponseMock = mock(HttpResponse.class);
		when(httpClientMock.execute(any(HttpPost.class))).thenReturn(httpResponseMock);
		when(httpResponseMock.getStatusLine()).thenReturn(new BasicStatusLine(mock(ProtocolVersion.class), 200, "yo"));
		final HttpEntity httpEntityMock = mock(HttpEntity.class);
		when(httpResponseMock.getEntity()).thenReturn(httpEntityMock);
		final InputStream inputStreamMock = mock(InputStream.class);
		when(httpEntityMock.getContent()).thenReturn(inputStreamMock);

		// when
		collector.collect(new Event("Test", "Action"));

		// then
		verify(inputStreamMock).close();
	}
}
