package com.candor.sp.client;

import com.candor.sp.client.gin.AppGinjector;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @author sp
 *
 */
public class ID3 extends AbstractEntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		/*
		 * Code Splitting performance driven choice.
		 * 
		 * This fragment is named as it is part of the initial fragments load sequence.
		 * 
		 * Render {@link AppFrame} framework.
		 */
		GWT.runAsync(AppFrame.class, new RunAsyncCallback() {

			@Override
			public void onSuccess() {
				setRootLayout(AppGinjector.INSTANCE.getAppFrame());
			}

			@Override
			public void onFailure(Throwable reason) {
				reason.printStackTrace();
			}
		});

	}
}
