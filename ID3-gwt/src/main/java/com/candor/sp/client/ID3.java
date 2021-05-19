package com.candor.sp.client;

import com.candor.sp.client.gin.AppGinjector;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.iron.IronIconElement;
import com.vaadin.polymer.paper.PaperButtonElement;
import com.vaadin.polymer.paper.PaperIconButtonElement;
import com.vaadin.polymer.paper.PaperInputElement;
import com.vaadin.polymer.vaadin.VaadinComboBoxElement;
import com.vaadin.polymer.vaadin.VaadinDatePickerElement;

import java.util.Arrays;

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
		Polymer.importHref(Arrays.asList(
				PaperInputElement.SRC,
				PaperIconButtonElement.SRC,
				PaperButtonElement.SRC,
				VaadinDatePickerElement.SRC,
				VaadinComboBoxElement.SRC),
				arg -> {//@formatter:on
					/*
					 * Code Splitting: performance driven choice
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
					return null;
				});




	}
}
