package com.android.td2.td2_android;

import android.os.Bundle;
import android.widget.NumberPicker;

/**
 * Created by Damien on 26/02/2017.
 */

public class PickerActivity extends android.app.Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picker);

        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
        np.setMinValue(10);
        np.setMaxValue(20);
    }
}
