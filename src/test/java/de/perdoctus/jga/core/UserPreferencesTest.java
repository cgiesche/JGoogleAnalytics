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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Giesche
 */
public class UserPreferencesTest {

	private UserPreferences userPreferences;


	@Before
	public void setUp() throws Exception {
		userPreferences = new UserPreferences(UUID.randomUUID().toString());
	}

	@After
	public void tearDown() throws Exception {
		userPreferences.purge();
	}

	@Test
	public void test_NonExistingFile() throws Exception {
		// then
		assertThat(userPreferences).isNotNull();
	}

	@Test
	public void test_StoreProperty() throws Exception {
		// when
		userPreferences.put("testKey", "testValue");
		userPreferences.save();

		final UserPreferences readUserPreferences = new UserPreferences(userPreferences.getAppPrefix());

		// then
		assertThat(readUserPreferences).isNotNull();
		assertThat(readUserPreferences.getProperty("testKey")).isEqualTo("testValue");
	}

	@Test
	public void test_PurgePreferences() throws Exception {
		// when
		userPreferences.put("testKey", "testValue");
		userPreferences.save();
		userPreferences.purge();

		final UserPreferences readUserPreferences = new UserPreferences(userPreferences.getAppPrefix());

		// then
		assertThat(readUserPreferences).isNotNull();
		assertThat(readUserPreferences.getProperty("testKey")).isNull();
	}
}
