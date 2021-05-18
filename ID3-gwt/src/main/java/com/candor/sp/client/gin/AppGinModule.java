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
import com.candor.sp.client.presenter.impl.ID3PresenterImpl;
import com.candor.sp.client.view.ID3View;
import com.candor.sp.client.view.impl.ID3ViewImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * @author sp
 *
 */
public class AppGinModule extends AbstractGinModule {

	/* Prevent explicit instantiation. */
	private AppGinModule() {
		// nothing to do
	}

	/**
	 * Configure GIN i.e. {@link AbstractGinModule#configure()}
	 */
	@Override
	protected void configure() {
		/* bind the EventBus as {@link Singleton} */
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

		/* bind 18n {@link Constants} */
		bind(I18nConstants.class).in(Singleton.class);
		bind(I18nLookupConstants.class).in(Singleton.class);
		bind(I18nMessages.class).in(Singleton.class);

		/* bind views as {@link Singleton} */
		bind(ID3View.class).to(ID3ViewImpl.class).in(Singleton.class);

		/* bind presenters */
		bind(ID3Presenter.class).to(ID3PresenterImpl.class);

		/* bind framework as {@link Singleton} */
		bind(AppFrame.class).in(Singleton.class);

		/* bind {@link DataManager} as {@link Singleton} */
		bind(DataManager.class).in(Singleton.class);
	}

}
