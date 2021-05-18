package com.candor.sp.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author sp
 *
 */
public class SelectPlaceEvent extends GwtEvent<SelectPlaceEventHandler> {

	public static final Type<SelectPlaceEventHandler> TYPE = new Type<SelectPlaceEventHandler>();

	private String placeId;

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SelectPlaceEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SelectPlaceEventHandler handler) {
		handler.select(this);
	}

	/**
	 * Constructor method.
	 * 
	 * @param placeId
	 */
	public SelectPlaceEvent(String placeId) {
		this.placeId = placeId;
	}

	/**
	 * @return the placeId
	 */
	public String getPlaceId() {
		return placeId;
	}

}
