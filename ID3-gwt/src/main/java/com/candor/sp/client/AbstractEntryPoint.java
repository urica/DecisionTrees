/**
 * 
 */
package com.candor.sp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * {@link EntryPoint} marker abstract class used in order to demonstrate deferred binding and
 * runtime replacements.
 * <p>
 * To be extended by all {@link EntryPoint} providers.
 * 
 * @author sp
 *
 */
public abstract class AbstractEntryPoint implements EntryPoint {

	/**
	 * Set the main container of the application in a {@link RootLayoutPanel}.
	 * 
	 * @param widget
	 *            widget to be rendered
	 */
	protected void setRootLayout(Widget widget) {
		// We have to load icon sets before run application
		RootLayoutPanel.get().clear();
		RootLayoutPanel.get().add(widget);

	}

}