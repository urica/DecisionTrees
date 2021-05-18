/**
 * 
 */
package com.candor.sp.client;

import com.candor.sp.client.gin.AppGinjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;

/**
 * {@link EntryPoint} implementation handling all unknown rendering engines.
 * 
 * @author sp
 *
 */
public class UnknownRenderingEngine extends AbstractEntryPoint {

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		setRootLayout(new HTML("<h1>" + AppGinjector.INSTANCE.getMessages().browserNotSupported(Window.Navigator.getUserAgent()) + "</h1>"));
	}

}
