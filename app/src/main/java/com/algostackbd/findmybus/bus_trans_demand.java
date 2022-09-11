package com.algostackbd.findmybus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class bus_trans_demand extends Fragment {
    String[] type1 = new String[]{"Teacher ","Student ","Stuff ","Others"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.update_transport_demands,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                getActivity(),
                R.layout.drop_down_item,
                type1
        );
        AutoCompleteTextView autoCompleteTextView1= view.findViewById(R.id.selectConsumer);
        autoCompleteTextView1.setAdapter(adapter1);
    }
}
