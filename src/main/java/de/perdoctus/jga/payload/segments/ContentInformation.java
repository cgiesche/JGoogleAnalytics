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
 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#content">Content Information</a>
 *
 * @author Christoph Giesche
 */
public class ContentInformation {

	private String documentLocation;
	private String documentHostName;
	private String documentPath;
	private String documentTitle;

	public ContentInformation() {
	}

	public ContentInformation(final String documentLocation, final String documentTitle) {
		this.documentLocation = documentLocation;
		this.documentTitle = documentTitle;
	}

	/**
	 * @param documentLocation Use this parameter to send the full URL (document location) of the page on which content resides. Be sure to remove any user authentication or other private information from the URL if present.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dl">Document location URL</a>
	 */
	@SuppressWarnings("unchecked")
	public ContentInformation documentLocation(final String documentLocation) {
		this.documentLocation = documentLocation;
		return this;
	}

	/**
	 * @param documentHostName Specifies the hostname from which content was hosted.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dh">Document Host Name</a>
	 */
	@SuppressWarnings("unchecked")
	public ContentInformation documentHostName(final String documentHostName) {
		this.documentHostName = documentHostName;
		return this;
	}

	/**
	 * @param documentPath The path portion of the page URL. Should begin with '/'.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dp">Document Path</a>
	 */
	@SuppressWarnings("unchecked")
	public ContentInformation documentPath(final String documentPath) {
		this.documentPath = documentPath;
		return this;
	}

	/**
	 * @param documentTitle The title of the page / document.
	 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/parameters#dt">Document Title</a>
	 */
	@SuppressWarnings("unchecked")
	public ContentInformation documentTitle(final String documentTitle) {
		this.documentTitle = documentTitle;
		return this;
	}

	public String getDocumentLocation() {
		return documentLocation;
	}

	public String getDocumentHostName() {
		return documentHostName;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public String getDocumentTitle() {
		return documentTitle;
	}
}
