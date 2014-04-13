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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import static org.mockito.Mockito.*;

/**
 * @author Christoph Giesche
 */
@RunWith(MockitoJUnitRunner.class)
public class CollectionRequestTest {

	@Test
	public void testPostData_Success() throws Exception {
		// given
		final CollectionRequest collectionRequest = new CollectionRequest("http://www.foo.bar", "bla");
		final HttpURLConnection httpURLConnectionMock = mock(HttpURLConnection.class);
		final OutputStream outputStreamMock = mock(OutputStream.class);

		when(httpURLConnectionMock.getOutputStream()).thenReturn(outputStreamMock);
		when(httpURLConnectionMock.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);

		// when
		collectionRequest.postData(httpURLConnectionMock);

		// then
		verify(httpURLConnectionMock).setDoOutput(true);
		verify(httpURLConnectionMock).setRequestMethod("POST");

		verify(outputStreamMock).write("bla".getBytes("UTF-8"));
		verify(outputStreamMock).close();
	}

	@Test
	public void testPostData_BadStatus() throws Exception {
		// given
		final CollectionRequest collectionRequest = new CollectionRequest("http://www.foo.bar", "bla");
		final HttpURLConnection httpURLConnectionMock = mock(HttpURLConnection.class);
		final OutputStream outputStreamMock = mock(OutputStream.class);

		when(httpURLConnectionMock.getOutputStream()).thenReturn(outputStreamMock);
		when(httpURLConnectionMock.getResponseCode()).thenReturn(HttpURLConnection.HTTP_UNAUTHORIZED);

		// when
		collectionRequest.postData(httpURLConnectionMock);

		// then
		verify(httpURLConnectionMock).setDoOutput(true);
		verify(httpURLConnectionMock).setRequestMethod("POST");

		verify(outputStreamMock).write("bla".getBytes("UTF-8"));
		verify(outputStreamMock).close();
	}

	@Test(expected = IOException.class)
	public void testPostData_GetOSFailed() throws Exception {
		// given
		final CollectionRequest collectionRequest = new CollectionRequest("http://www.foo.bar", "bla");
		final HttpURLConnection httpURLConnectionMock = mock(HttpURLConnection.class);

		when(httpURLConnectionMock.getOutputStream()).thenThrow(new IOException());

		// when
		collectionRequest.postData(httpURLConnectionMock);

		// then
		verify(httpURLConnectionMock).setDoOutput(true);
		verify(httpURLConnectionMock).setRequestMethod("POST");
	}
}
