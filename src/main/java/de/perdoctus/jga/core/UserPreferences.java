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

import java.io.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Christoph Giesche
 */
public class UserPreferences extends Properties {

	private static final String PREFS_FILE_SUFFIX = "_pd.prefs";
	private static final String SYSPROP_USER_HOME = "user.home";
	private final String appPrefix;
	private final File preferencesFile;

	public UserPreferences(final String appPrefix) throws IOException {
		this.appPrefix = appPrefix;
		Objects.requireNonNull(appPrefix);

		final String userHomeDirectory = System.getProperty(SYSPROP_USER_HOME);
		final String preferencesPath = userHomeDirectory + File.separatorChar + appPrefix + PREFS_FILE_SUFFIX;

		preferencesFile = new File(preferencesPath);

		if (preferencesFile.exists()) {
			load(preferencesFile);
		}
	}

	public String getAppPrefix() {
		return appPrefix;
	}

	public void save() throws IOException {
		try (final OutputStream preferencesOutputStream = new FileOutputStream(preferencesFile)) {
			store(preferencesOutputStream, null);
		}
	}

	public void purge() {
		preferencesFile.delete();
	}

	private void load(final File preferencesFile) throws IOException {
		try (final FileInputStream fileInputStream = new FileInputStream(preferencesFile)) {
			this.load(fileInputStream);
		}
	}

}
