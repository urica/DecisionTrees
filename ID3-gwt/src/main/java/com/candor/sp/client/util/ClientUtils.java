/**
 * 
 */
package com.candor.sp.client.util;

import com.candor.sp.client.AppFrame;
import com.candor.sp.client.events.NotificationEvent;
import com.candor.sp.client.gin.AppGinjector;
import com.candor.sp.client.view.impl.ID3ViewImpl;
import com.candor.sp.server.implementation.ID3;

/**
 * Non-inheritable client utility class.
 * 
 * @author sp
 *
 */
public class ClientUtils {

	/* Prevent instantiation. */
	private ClientUtils() {
		/*
		 * Just in case new instance is created inside the class and/or through GWT.create(), DI
		 */
		throw new AssertionError(getClass().getName() + " utility class cannot be instatiated.");
	}

	/**
	 * @param message
	 */
	public static void showNotification(String message) {
		showNotification(message, AppFrame.class);
	}

	/**
	 * @param message
	 */
	public static void showNotification(String message, Object source) {
		AppGinjector.INSTANCE.getEventBus().fireEventFromSource(new NotificationEvent(message), source);
	}
}
