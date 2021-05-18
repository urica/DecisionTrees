package com.candor.bp.client.jsi;

import com.google.gwt.dom.client.Element;
import elemental2.dom.Event;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * jQuery-to-Java JsInterop wrapper class to provide convenience methods for calling <b>jQuery</b> functions from Java.
 *
 * <p>
 * Setting isNative to true will tell GWT not to generate any code, as all implementation is available within the jQuery
 * JavaScript library
 * </p>
 *
 * @author bp
 */
@JsType(isNative = true)
public class JQuery {

    // prevent manual instantiation
    private JQuery() {
        // nothing to do
    }

    // define contract for jQuery $ property with String selector
    @JsMethod(namespace = JsPackage.GLOBAL)
    public native static JQuery $(String selector);

    // define contract for jQuery $ property with {@link Element} selector
    @JsMethod(namespace = JsPackage.GLOBAL)
    public native static JQuery $(Element element);

    // define contract for jQuery $ property with {@link HTMLElement} selector
    @JsMethod(namespace = JsPackage.GLOBAL)
    public native static JQuery $(elemental2.dom.Element element);

    // define contract for jQuery slideToggle function
    public native JQuery slideToggle(String speed);
    public native JQuery slideToggle(int duration, String easing);

    // define contract for jQuery toggleClass function
    public native JQuery toggleClass(String className);

    // define contract for jQuery find function
    public native JQuery find(String className);

    // define contract for jQuery appendTo function
    public native JQuery appendTo(JQuery jQueryElement);

    // define contract for jQuery appendTo function
    public native JQuery appendTo(String selector);

    // define contract for jQuery first function
    public native JQuery first();

    // define contract for jQuery first function
    public native JQuery disableSelection();

    // define contract for jQuery first function
    public native JQuery children(String className);

    // define contract for jQuery first function
    public native JQuery children();

    // define contract for jQuery removeClass function
    public native JQuery removeClass(String className);

    // define contract for jQuery attr function
    public native JQuery attr(String attributeName);

    // define contract for jQuery attr function
    public native JQuery attr(String attributeName, String value);

    // define contract for jQuery attr function
    public native JQuery attr(String attributeName, boolean value);

    // define contract for jQuery get function
    public native Element get(int index);

    // define contract for jQuery get function
    public native Element[] get();

    // define contract for jQuery prop function
    public native JQuery prop(String propertyName);

    // define contract for jQuery prop function
    public native JQuery prop(String propertyName, boolean propValue);

    // define contract for jQuery removeProp function
    public native JQuery removeProp(String propertyName);

    // define contract for jQuery removeAttr function
    public native JQuery removeAttr(String attributeName);

    // define contract for jQuery css function
    public native JQuery css(String propertyName);

    // define contract for jQuery css function
    public native JQuery css(String propertyName, String value);

    // define contract for jQuery remove function
    public native JQuery remove();

    // define contract for jQuery hide function
    public native JQuery hide();

    // define contract for jQuery hasClass function
    public native boolean hasClass(String className);

    // define contract for jQuery addClass function
    public native JQuery addClass(String className);

    // define contract for jQuery contents function
    public native JQuery contents();

    // define contract for jQuery closest function
    public native JQuery closest(String query);

    // define contract for jQuery slideDown function
    public native JQuery slideDown();

    // define contract for jQuery slideUp function
    public native JQuery slideUp();

    // define contract for jQuery size function
    public native int size();

    // define contract for jQuery text function
    public native String text();

    // define contract for jQuery text function
    public native String text(String value);

    // define contract for jQuery html function
    public native String html();

    // define contract for jQuery is function
    public native boolean is(String selector);

    // define contract for jQuery show function
    public native JQuery show();

    // define contract for jQuery parents function
    public native JQuery parents();

    // define contract for jQuery parent function
    public native JQuery parent();

    // define contract for jQuery clone function
    public native JQuery clone();

    // define contract for jQuery droppable function
    public native JQuery droppable();


    // define contract for jQuery replaceWith function
    public native JQuery replaceWith(elemental2.dom.Element replaceWith);

    // define contract for jQuery replaceWith function
    public native JQuery replaceWith(String replaceWith);

    // define contract for jQuery replaceWith function
    public native JQuery replaceWith(Element replaceWith);

    // define contract for jQuery append with {@link Element} selector
    public native JQuery append(Element element);

    // define contract for jQuery append with String selector
    public native JQuery append(String selector);

    // define contract for jQuery empty function
    public native JQuery empty();
    
    // define contract for jQuery blur function
    public native JQuery blur();

}