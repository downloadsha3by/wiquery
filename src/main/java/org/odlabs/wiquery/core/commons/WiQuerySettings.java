/*
 * Copyright (c) 2009 WiQuery team
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.odlabs.wiquery.core.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.wicket.Application;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.resources.JavascriptResourceReference;
import org.odlabs.wiquery.core.commons.listener.WiQueryPluginRenderingListener;

/**
 * $Id$
 * 
 * <p>
 * Bean to get the wiQuery settings
 * </p>
 * 
 * @author Julien Roche
 * @since 1.1
 */
public class WiQuerySettings implements Serializable {
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 4047364411001306905L;

	/**
	 * Get {@link WiQuerySettings} for current thread.
	 * 
	 * @return The settings
	 */
	public static WiQuerySettings get() {
		WiQuerySettings instance = Application.get().getMetaData(
				WiQueryInitializer.WIQUERY_INSTANCE_KEY);

		if (instance == null) {
			throw new WicketRuntimeException(
					"There is no WiQueryInstantiationListener attached to the application "
							+ Thread.currentThread().getName());
		}

		return instance;
	}

	// Properties
	private boolean autoImportJQueryResource;
	private List<WiQueryPluginRenderingListener> listeners;
	private JavascriptResourceReference jQueryCoreResourceReference;
	private boolean autoImportJQueryUIResource;
	private boolean enableWiqueryResourceManagement;

	/**
	 * Default constructor
	 */
	public WiQuerySettings() {
		super();

		this.autoImportJQueryUIResource = true;
		this.enableWiqueryResourceManagement = true;

		autoImportJQueryResource = true;
		listeners = new ArrayList<WiQueryPluginRenderingListener>();
		jQueryCoreResourceReference = null;
	}

	/**
	 * Method adding a {@link WiQueryPluginRenderingListener}
	 * 
	 * @param listener
	 * @return the state
	 */
	public boolean addListener(WiQueryPluginRenderingListener listener) {
		return listeners.add(listener);
	}

	/**
	 * @return the list of listener from the listeners option
	 */
	public ListIterator<WiQueryPluginRenderingListener> getListeners() {
		return listeners.listIterator();
	}

	/**
	 * @return the state of the autoImportJQueryResource option
	 */
	public boolean isAutoImportJQueryResource() {
		return autoImportJQueryResource;
	}

	/**
	 * Set the autoImportJQueryResource option. If false, the jQuery core
	 * resource will be not loaded
	 * 
	 * @param autoImportJQueryResource
	 */
	public void setAutoImportJQueryResource(boolean autoImportJQueryResource) {
		this.autoImportJQueryResource = autoImportJQueryResource;
	}

	/**
	 * @return the {@link JavascriptResourceReference} where we can find the
	 *         jQuery core
	 */
	public JavascriptResourceReference getJQueryCoreResourceReference() {
		return jQueryCoreResourceReference;
	}

	/**
	 * Set the jQuery core to use
	 * 
	 * @param jQueryCoreResourceReference
	 */
	public void setJQueryCoreResourceReference(
			JavascriptResourceReference jQueryCoreResourceReference) {
		this.jQueryCoreResourceReference = jQueryCoreResourceReference;
	}

	public boolean isAutoImportJQueryUIResource() {
		return autoImportJQueryUIResource;
	}

	/**
	 * If set to <code>false</code>, no jQueryUI resources are contributed by
	 * the framework, which means the user is responsible to add required
	 * resources (javascript and css files) for jQueryUI to work. Useful if one
	 * wants to manage resources globally or use a CDN network to load
	 * resources.
	 * <p/>
	 * <b>Warning:</b> If version does not match to the version contributed by
	 * the framework, functionality may be harmed!
	 * 
	 * @param autoImportJQueryUIResource
	 *            <code>true</code> to let the framework import required
	 *            resources. <code>false</code> to disable automatic resources
	 *            contribution by the framework.
	 * @see #setEnableWiqueryResourceManagement(boolean)
	 */
	public void setAutoImportJQueryUIResource(boolean autoImportJQueryUIResource) {
		this.autoImportJQueryUIResource = autoImportJQueryUIResource;
	}

	public boolean isEnableWiqueryResourceManagement() {
		return enableWiqueryResourceManagement;
	}

	/**
	 * If set to <code>false</code>, <b>all</b> resource contributions by
	 * Wiquery are disabled. No jQuery or jQueryUI resource are contributed by
	 * the framework, nor any resources from plugins. Useful if one wants to
	 * manage resources globally or use a CDN network to load resources.
	 * <p/>
	 * <b>Warning:</b> By setting this to <code>false</code> the frameworks
	 * functionality (or parts of it) is not guaranteed anymore! Activate only
	 * if you know what you do and import required resources manually.
	 * <p/>
	 * Sets internally {@link #setAutoImportJQueryResource(boolean)} and
	 * {@link #setAutoImportJQueryUIResource(boolean)} to the given value.
	 * 
	 * @param enableWiqueryResourceManagement
	 *            <code>false</code> disables all resources contributions by the
	 *            framework. <code>true</code> enables it (default).
	 * @see #setAutoImportJQueryResource(boolean)
	 * @see #setAutoImportJQueryUIResource(boolean)
	 */
	public void setEnableWiqueryResourceManagement(
			boolean enableWiqueryResourceManagement) {
		this.autoImportJQueryUIResource = enableWiqueryResourceManagement;
		this.autoImportJQueryResource = enableWiqueryResourceManagement;
		this.enableWiqueryResourceManagement = enableWiqueryResourceManagement;
	}
}
