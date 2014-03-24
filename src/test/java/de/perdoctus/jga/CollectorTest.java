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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * @author Christoph Giesche
 */
@RunWith(MockitoJUnitRunner.class)
public class CollectorTest {

	@Mock
	private HttpClient httpClientMock;
	@Mock
	private ExecutorService executorServiceMock;

	private Configuration configurationMock = ConfigurationBuilder.httpEndpoint("foo").build();

	private Collector collector;

	@Before
	public void setUp() throws Exception {
		this.collector = new Collector(configurationMock, httpClientMock, executorServiceMock);
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

	public static void main(String[] args) {
		final String USER_AGENT = "Apache-HttpClient/4.3.3 (%s ; %s;)";
		final String userAgentString = String.format(USER_AGENT, System.getProperty("os.name"), System.getProperty("os.arch"));
		System.out.println(userAgentString);
	}
}
