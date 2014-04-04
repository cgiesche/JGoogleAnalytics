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
import org.apache.http.client.HttpClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Christoph Giesche
 */
@RunWith(MockitoJUnitRunner.class)
public class CollectorTest {

	@Mock
	private HttpClient httpClientMock;

	@Mock
	private ExecutorService executorServiceMock;

	@Mock
	private Configuration configurationMock;

	private Collector collector;

	@Before
	public void setUp() throws Exception {
		collector = new Collector(configurationMock, SystemInfo.autoDetect(), httpClientMock, executorServiceMock);
		when(configurationMock.getEndpointURL()).thenReturn("http://www.foo.bar");
		when(executorServiceMock.awaitTermination(anyLong(), any(TimeUnit.class))).thenReturn(true);
	}

	@Test
	public void testConstruct() throws Exception {
		// when
		new Collector(configurationMock);
	}

	@Test
	public void testCollectEvent() throws Exception {
		// when
		collector.collect(new Event("Test", "Action"));

		// then
		verify(executorServiceMock).submit(any(CollectionRequest.class));
	}

	@Test
	public void testCollectEvent_TerminationTimeout() throws Exception {
		// given
		when(executorServiceMock.awaitTermination(anyLong(), any(TimeUnit.class))).thenReturn(false);

		// when
		collector.collect(new Event("Test", "Action"));

		// then
		verify(executorServiceMock).submit(any(CollectionRequest.class));
	}

	@Test
	public void testCollectEvent_TerminationInterrupted() throws Exception {
		// given
		when(executorServiceMock.awaitTermination(anyLong(), any(TimeUnit.class))).thenThrow(new InterruptedException());

		// when
		collector.collect(new Event("Test", "Action"));

		// then
		verify(executorServiceMock).submit(any(CollectionRequest.class));
	}

}
