package com.algostackbd.findmybus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bus_trans_demand extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.update_transport_demands,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] type1 = new String[]{"Teacher ","Student ","Stuff ","Others"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                getActivity(),
                R.layout.drop_down_item,
                type1
        );
        AutoCompleteTextView autoCompleteTextView2= view.findViewById(R.id.selectConsumer);
        autoCompleteTextView2.setAdapter(adapter1);

        //textinput and button//------------------------------------------------------------
        TextInputEditText route,timeslote;
        Button cdUpbtn;

        route =(TextInputEditText) view.findViewById(R.id.cdroute);
        timeslote = (TextInputEditText)view.findViewById(R.id.cdTime);
        cdUpbtn = (Button) view.findViewById(R.id.updateInfo);
        cdUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String RouteNum = route.getText().toString();
                String time_slote =  timeslote.getText().toString();;
                String Consumer_catagory = autoCompleteTextView2.getText().toString();

                if(RouteNum.isEmpty()){
                    route.setError("Bus Licence Number cannot be empty");
                    route.requestFocus();
                }else if( time_slote.isEmpty()){
                    timeslote.setError("CodeNumber cannot be empty");
                    timeslote.requestFocus();
                }else{

                   busdemandHelper helper = new busdemandHelper (RouteNum,time_slote,Consumer_catagory);

                    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                    DatabaseReference root = rootNode.getReference("Transport_Demands");
                    root.child(RouteNum).setValue(helper);


                    route.setText("");
                    timeslote.setText("");
                    autoCompleteTextView2.setText("");
                    Toast.makeText(getActivity().getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

                }


            }
        });



    }
}
