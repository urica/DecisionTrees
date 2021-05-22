package com.candor.sp.client.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author bp
 */
public class NotificationEvent extends GwtEvent<NotificationEventHandler> {

    public static final Type<NotificationEventHandler> TYPE = new Type<NotificationEventHandler>();

    private String message;

    /**
     * Constructor method.
     *
     * @param message
     */
    public NotificationEvent(String message) {
        this.message = message;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<NotificationEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(NotificationEventHandler handler) {
        handler.notify(this);
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}