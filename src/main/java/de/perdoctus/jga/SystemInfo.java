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

import de.perdoctus.jga.annotation.AnalyticsParameter;
import de.perdoctus.jga.payload.AnalyticsParamNames;
import de.perdoctus.jga.payload.types.BooleanValue;

import java.awt.*;
import java.util.Locale;

/**
 * @author Christoph Giesche
 */
public class SystemInfo {

	@AnalyticsParameter(AnalyticsParamNames.SCREEN_RESOLUTION)
	private String screenResolution;
	@AnalyticsParameter(AnalyticsParamNames.VIEWPORT_SIZE)
	private String viewportSize;
	@AnalyticsParameter(AnalyticsParamNames.DOCUMENT_ENCODING)
	private String documentEncoding;
	@AnalyticsParameter(AnalyticsParamNames.SCREEN_COLORS)
	private String screenColors;
	@AnalyticsParameter(AnalyticsParamNames.USER_LANGUAGE)
	private String userLanguage;
	@AnalyticsParameter(AnalyticsParamNames.JAVA_ENABLED)
	private BooleanValue javaEnabled;
	@AnalyticsParameter(AnalyticsParamNames.FLASH_VERSION)
	private String flashVersion;

	/**
	 * Returns a preconfigured instance of SystemInfo. The following fields are filled automatically:
	 * <ul>
	 * <li>userLanguage (default locale)</li>
	 * <li>documentEncoding (system property: file.encoding)</li>
	 * <li>javaEnabled (true, as we are using java)</li>
	 * <li>screenResolution (for primary screen)</li>
	 * </ul>
	 *
	 * @return The preconfigured SystemInfo.
	 */
	public static SystemInfo autoDetect() {
		final SystemInfo systemInfo = new SystemInfo()
				.userLanguage(Locale.getDefault())
				.documentEncoding(System.getProperty("file.encoding"))
				.javaEnabled(BooleanValue.TRUE);

		try {
			final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			if (screenSize != null) {
				systemInfo.screenResolution(screenSize.width, screenSize.height);
			}
		} catch (final Exception e) {
			// ignore
		}

		return systemInfo;
	}

	/**
	 * Specifies the screen resolution.
	 *
	 * @param width  Screen width in pixels.
	 * @param height Screen height in pixels.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#sr">Screen Resolution</a>
	 */
	public SystemInfo screenResolution(final int width, final int height) {
		this.screenResolution = width + "x" + height;
		return this;
	}

	/**
	 * Specifies the viewable area of the browser / device.
	 *
	 * @param width  Viewport width in pixels.
	 * @param height Viewport height in pixels.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#vp">Viewport size</a>
	 */
	public SystemInfo viewportSize(final int width, final int height) {
		this.viewportSize = width + "x" + height;
		return this;
	}

	/**
	 * @param documentEncoding Specifies the character set used to encode a page / document.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#de">Document Encoding</a>
	 */
	public SystemInfo documentEncoding(final String documentEncoding) {
		this.documentEncoding = documentEncoding;
		return this;
	}

	/**
	 * @param screenColors Specifies the screen color depth.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#sd">Screen Colors</a>
	 */
	public SystemInfo screenColors(final String screenColors) {
		this.screenColors = screenColors;
		return this;
	}

	/**
	 * @param locale Specifies the language from given Locale.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#ul">User Language</a>
	 */
	public SystemInfo userLanguage(final Locale locale) {
		this.userLanguage = locale.toLanguageTag();
		return this;
	}

	/**
	 * @param javaEnabled Specifies whether Java is enabled.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#je">Java Enabled</a>
	 */
	public SystemInfo javaEnabled(BooleanValue javaEnabled) {
		this.javaEnabled = javaEnabled;
		return this;
	}

	/**
	 * @param flashVersion Specifies the flash version.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#fl">Flash Version</a>
	 */
	public SystemInfo flashVersion(final String flashVersion) {
		this.flashVersion = flashVersion;
		return this;
	}

	public String getScreenResolution() {
		return screenResolution;
	}

	public String getViewportSize() {
		return viewportSize;
	}

	public String getDocumentEncoding() {
		return documentEncoding;
	}

	public String getScreenColors() {
		return screenColors;
	}

	public String getUserLanguage() {
		return userLanguage;
	}

	public BooleanValue isJavaEnabled() {
		return javaEnabled;
	}

	public String getFlashVersion() {
		return flashVersion;
	}

}
