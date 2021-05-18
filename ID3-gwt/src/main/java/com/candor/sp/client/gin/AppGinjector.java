/**
 * 
 */
package com.candor.sp.client.gin;

import com.candor.sp.client.AppFrame;
import com.candor.sp.client.DataManager;
import com.candor.sp.client.i18n.I18nConstants;
import com.candor.sp.client.i18n.I18nLookupConstants;
import com.candor.sp.client.i18n.I18nMessages;
import com.candor.sp.client.presenter.ID3Presenter;
import com.candor.sp.client.view.ID3View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * @author sp
 *
 */
@GinModules(AppGinModule.class)
public interface AppGinjector extends Ginjector {

	/* {@link AppGinjector} compile time constant */
	public static final AppGinjector INSTANCE = GWT.create(AppGinjector.class);

	// event bus
	EventBus getEventBus();

	// i18n
	I18nConstants getConstants();
	I18nLookupConstants getLookupConstants();
	I18nMessages getMessages();

	// view
	ID3View getCityView();

	// presenter
	ID3Presenter getCityPresenter();

	// framework
	AppFrame getAppFrame();

	// data manager
	DataManager getDataManager();
}
