package org.odlabs.wiquery.presentation.examples.ui.layout;

import org.apache.wicket.markup.html.resources.JavascriptResourceReference;

/**
 * $Id$
 * <p>
 * References the jQuery UI Layout javascript.
 * </p>
 * 
 * @author Julien Roche
 */
public class LayoutJavascriptResourceReference extends
		JavascriptResourceReference {
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 4585057795574929263L;

	/** Singleton instance */
	private static LayoutJavascriptResourceReference instance;

	/**
	 * Builds a new instance of {@link LayoutJavascriptResourceReference}.
	 */
	private LayoutJavascriptResourceReference() {
		super(LayoutJavascriptResourceReference.class, "jquery.layout.js");
	}
	
	/**
	 * @return the instance
	 */
	public static LayoutJavascriptResourceReference get() {
		if (instance == null) {
			instance = new LayoutJavascriptResourceReference();
		}
		return instance;
	}
}
