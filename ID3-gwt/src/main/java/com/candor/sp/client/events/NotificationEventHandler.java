package com.candor.sp.client.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * {@link FunctionalInterface} providing the means of handling a
 * {@NotificationEvent}
 *
 * @author bp
 */
@FunctionalInterface
public interface NotificationEventHandler extends EventHandler {

    /**
     * @param event {@link NotificationEvent}
     */
    void notify(NotificationEvent event);

}