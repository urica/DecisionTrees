package com.candor.sp.client.presenter;

import com.candor.sp.shared.DataFraud;

import java.util.List;

/**
 * @author sp
 *
 */
public interface ID3Presenter extends Presenter {

    void onCreateTable(String gainType);

    void getAllColumnNames();

    void getAllValues(String column);

    void testData(DataFraud dataFraud);

}
