/**
 *
 */
package com.candor.sp.client.view;

import com.candor.sp.client.presenter.ID3Presenter;
import com.google.gwt.user.client.ui.IsWidget;
import elemental2.dom.HTMLElement;

/**
 * @author sp
 *
 */
public interface ID3View extends IsWidget {

    void setPresenter(ID3Presenter presenter);

    void createTree(String tree);

    HTMLElement getFields();

}
