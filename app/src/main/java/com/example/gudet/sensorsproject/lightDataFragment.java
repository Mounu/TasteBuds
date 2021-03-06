package com.example.gudet.sensorsproject;

import android.hardware.Sensor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class lightDataFragment extends Fragment {
    private Sensor sensorTypeL;

    EditText lIntensity, lMinValue, lMaxValue, lAvgValue;
    ArrayList<Float> arrayList;
    CommonMethods commonMethods = new CommonMethods();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lightdata_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayList = (ArrayList<Float>)getArguments().getSerializable("valueLight");
        Log.d("light val" , " "+arrayList);

        if(arrayList.size() > 0) {

            EditText lIntensity = view.findViewById(R.id.LIntensity);
            EditText lMinValue = view.findViewById(R.id.LMinValue);
            EditText lMaxValue = view.findViewById(R.id.LMaxValue);
            EditText lAvgValue = view.findViewById(R.id.LAvgValue);

            String myfloatvariable = " " + arrayList.get(1);
            lIntensity.setText(myfloatvariable);

            Float minValue = commonMethods.getMinValue(arrayList);
            lMinValue.setText("" + minValue);

            Float maxValue = commonMethods.getMaxValue(arrayList);
            lMaxValue.setText("" + maxValue);

            Float avg = commonMethods.getAvgValue(arrayList);
            lAvgValue.setText("" + avg);

        }
    }
}