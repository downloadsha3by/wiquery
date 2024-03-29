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
package org.odlabs.wiquery.core.util;

import java.io.Serializable;

import org.apache.wicket.Component;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;
import org.odlabs.wiquery.core.IWiQueryPlugin;

/**
 * $Id: WiQueryPluginVisitor.java 634 2010-12-24 14:42:09Z hielke.hoeve@gmail.com $
 * <p>
 * Visits component hierarchy to find plugins both in components and behaviors
 * </p>
 * 
 * @author Lionel Armanet
 * @since 1.0-m2
 */
public class WiQueryPluginVisitor implements IVisitor<Component, Boolean>, Serializable
{

	private static final long serialVersionUID = -4147296857772880048L;

	private IWiQueryPlugin wiQueryPlugin;

	public WiQueryPluginVisitor(IWiQueryPlugin wiQueryPlugin)
	{
		super();
		this.wiQueryPlugin = wiQueryPlugin;
	}

	public void component(Component component, IVisit<Boolean> visit)
	{
		if (component.getBehaviors().contains(this.wiQueryPlugin))
		{
			visit.stop(Boolean.TRUE);
		}
		if (component.equals(this.wiQueryPlugin))
		{
			visit.stop(Boolean.TRUE);
		}
	}
}
