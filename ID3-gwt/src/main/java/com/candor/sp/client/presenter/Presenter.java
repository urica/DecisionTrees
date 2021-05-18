package com.candor.sp.client.presenter;

import com.google.gwt.user.client.ui.HasOneWidget;
/**
 * Marker Presenter interface.
 * 
 * @author sp
 *
 */
public interface Presenter {
	public void go(final HasOneWidget container);
	public void bind();
}
