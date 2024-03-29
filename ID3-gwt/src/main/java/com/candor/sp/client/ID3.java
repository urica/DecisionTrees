package com.candor.sp.client;

import com.candor.sp.client.gin.AppGinjector;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.vaadin.polymer.Polymer;
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
 */
public class ID3 extends AbstractEntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        Polymer.importHref(Arrays.asList(
                PaperInputElement.SRC,
                PaperIconButtonElement.SRC,
                PaperButtonElement.SRC,
                "vaadin-combo-box/vaadin-combo-box.html",
                VaadinDatePickerElement.SRC,
                VaadinComboBoxElement.SRC),
                arg -> {
                    GWT.runAsync(AppFrame.class, new RunAsyncCallback() {

                        @Override
                        public void onSuccess() {
                            setRootLayout(AppGinjector.INSTANCE.getAppFrame());
                        }

                        @Override
                        public void onFailure(Throwable reason) {
                            GWT.log("Fail to start!");
                        }
                    });
                    return null;
                });
    }
}
