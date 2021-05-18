package com.candor.sp.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * {@link FunctionalInterface} providing the means of handling a {@SelectPlaceEvent}
 * 
 * @author sp
 */
@FunctionalInterface
public interface SelectPlaceEventHandler extends EventHandler {

	/**
	 * 
	 * @param event
	 *            {@link SelectPlaceEvent}
	 */
	void select(SelectPlaceEvent event);

}