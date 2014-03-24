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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.*;

/**
 * @author Christoph Giesche
 */
@RunWith(MockitoJUnitRunner.class)
public class CollectionRequestTest {

	@Mock
	private HttpClient httpClientMock;
	@Mock
	private HttpPost httpPostMock;

	@Test
	public void testRun_OK_NoEntity() throws Exception {
		// given
		final CollectionRequest collectionRequest = new CollectionRequest(httpClientMock, httpPostMock);
		final HttpResponse httpResponseMock = mock(HttpResponse.class);
		when(httpClientMock.execute(httpPostMock)).thenReturn(httpResponseMock);
		final StatusLine statusLineMock = mock(StatusLine.class);
		when(httpResponseMock.getStatusLine()).thenReturn(statusLineMock);
		when(statusLineMock.getStatusCode()).thenReturn(HttpStatus.SC_OK);

		// when
		collectionRequest.run();

		// then
		verify(httpPostMock).releaseConnection();
	}

	@Test
	public void testRun_OK_WithEntity() throws Exception {
		// given
		final CollectionRequest collectionRequest = new CollectionRequest(httpClientMock, httpPostMock);
		final HttpResponse httpResponseMock = mock(HttpResponse.class);
		when(httpClientMock.execute(httpPostMock)).thenReturn(httpResponseMock);
		final StatusLine statusLineMock = mock(StatusLine.class);
		when(httpResponseMock.getStatusLine()).thenReturn(statusLineMock);
		when(statusLineMock.getStatusCode()).thenReturn(HttpStatus.SC_OK);
		final HttpEntity httpEntityMock = mock(HttpEntity.class);
		when(httpResponseMock.getEntity()).thenReturn(httpEntityMock);
		final InputStream inputStreamMock = mock(InputStream.class);
		when(httpEntityMock.getContent()).thenReturn(inputStreamMock);

		// when
		collectionRequest.run();

		// then
		verify(inputStreamMock).close();
		verify(httpPostMock).releaseConnection();
	}

	@Test
	public void testRun_NOK_NoException() throws Exception {
		// given
		final CollectionRequest collectionRequest = new CollectionRequest(httpClientMock, httpPostMock);
		final HttpResponse httpResponseMock = mock(HttpResponse.class);
		when(httpClientMock.execute(httpPostMock)).thenReturn(httpResponseMock);
		final StatusLine statusLineMock = mock(StatusLine.class);
		when(httpResponseMock.getStatusLine()).thenReturn(statusLineMock);
		when(statusLineMock.getStatusCode()).thenReturn(HttpStatus.SC_BAD_GATEWAY);

		// when
		collectionRequest.run();

		// then
		verify(httpPostMock).releaseConnection();
	}

	@Test
	public void testRun_IOException_NoException() throws Exception {
		// given
		final CollectionRequest collectionRequest = new CollectionRequest(httpClientMock, httpPostMock);
		when(httpClientMock.execute(httpPostMock)).thenThrow(new IOException());

		// when
		collectionRequest.run();

		// then
		verify(httpPostMock).releaseConnection();
	}
}
