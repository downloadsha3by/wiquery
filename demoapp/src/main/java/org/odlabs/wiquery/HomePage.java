package org.odlabs.wiquery;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.odlabs.wiquery.panels.CorePanel;
import org.odlabs.wiquery.ui.accordion.Accordion;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {
    	add(new Accordion("leftMenu"));
    	add(new CorePanel("content"));
    }
}
