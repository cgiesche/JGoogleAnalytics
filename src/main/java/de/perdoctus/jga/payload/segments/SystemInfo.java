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

/**
 * @author Christoph Giesche
 */
public class SystemInfo {

	public static final String KEY_SCREEN_RESOLUTION = "sc";
	public static final String KEY_VIEWPORT_SIZE = "vp";
	public static final String KEY_DOCUMENT_ENCODING = "de";
	public static final String KEY_SCREEN_COLORS = "sd";
	private String screenResolution;
	private String viewportSize;
	private String documentEncoding;
	private String screenColors;

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
}
