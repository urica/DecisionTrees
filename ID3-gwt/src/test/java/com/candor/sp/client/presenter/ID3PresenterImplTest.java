package com.candor.sp.client.presenter;

import com.candor.sp.client.jsi.JQuery;
import com.candor.sp.client.presenter.impl.ID3PresenterImpl;
import com.candor.sp.client.view.ID3View;
import com.candor.sp.shared.DataFraud;
import com.candor.sp.shared.GainType;
import com.google.gwt.core.client.GWT;
import com.google.gwtmockito.GwtMockitoTestRunner;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GwtMockitoTestRunner.class)
public class ID3PresenterImplTest extends TestCase {

    @Before
    public final void init() {
//        GWTMockUtilities.disarm();
    }

    @Test
    public void testAssert() {
        ID3View view = GWT.create(ID3View.class);
        ID3PresenterImpl presenter = new ID3PresenterImpl(view);
        assertTrue(view.getFields().childElementCount == 0);
        presenter.getAllColumnNames();
        presenter.getAllValues("Age");
        presenter.testData(new DataFraud());
        presenter.onCreateTable(GainType.GAIN_RATIO.getValue());
        JQuery.$(view.getFields()).children();

        presenter.showPopup("My msg");
    }
}
