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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class busInventory_update extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bus_inventory_update,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] isActive = new String[]{"Active ","Not Active "};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                getActivity(),
                R.layout.drop_down_item,
                isActive
        );
        AutoCompleteTextView autoCompleteTextView1= view.findViewById(R.id.isActiveDrop);
        autoCompleteTextView1.setAdapter(adapter1);


        //textinput and button//------------------------------------------------------------
        TextInputEditText buslicence,codename,capacity, busDname, contactNumber;
        Button inUpbtn;
        //-----------------------------------------------------------------

        //findViewById-----------------------------------------------------
        buslicence =(TextInputEditText) view.findViewById(R.id.licenceNumberUpdate);
        codename = (TextInputEditText)view.findViewById(R.id.codeNameUpdate);
        capacity =(TextInputEditText) view.findViewById(R.id.Capacityupdate);
        busDname = (TextInputEditText)view.findViewById(R.id.driverFullNameUpdate);
        contactNumber =(TextInputEditText) view.findViewById(R.id.driverContactNumberUpdate);
        inUpbtn = (Button) view.findViewById(R.id.updateInfoFromAdminBtn);

        inUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Bus_Licence_Num = buslicence.getText().toString();
                String CodeNum = codename.getText().toString();
                String Capacity = capacity.getText().toString();
                String Driver_name = busDname.getText().toString();
                String DriveConNum = contactNumber.getText().toString();
                String BusCondition = autoCompleteTextView1.getText().toString();

                if(Bus_Licence_Num.isEmpty()){
                    buslicence.setError("Bus Licence Number cannot be empty");
                    buslicence.requestFocus();
                }else if(CodeNum.isEmpty()){
                    codename.setError("CodeNumber cannot be empty");
                    codename.requestFocus();
                }else if(Capacity.isEmpty()){
                    capacity.setError("Capacity cannot be empty");
                    capacity.requestFocus();
                }else if(Driver_name .isEmpty()){
                    busDname.setError("Dricer Name cannot be empty");
                    busDname.requestFocus();

                }else if(DriveConNum.isEmpty()){
                    contactNumber.setError("Driver Contact Number cannot be empty");
                    contactNumber.requestFocus();

                } else if(BusCondition.isEmpty()){
                    contactNumber.setError("Bus Condition cannot be empty");
                    contactNumber.requestFocus();

                }else{

                    adminHelper helper = new adminHelper(Bus_Licence_Num,CodeNum,Capacity,Driver_name,DriveConNum,BusCondition);

                    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                    DatabaseReference root = rootNode.getReference("Bus_inventory");
//                root.child(e_Divison).child(b_Bussines_Type).child(f_Licence_Number).setValue(helper);
                    root.child(CodeNum).setValue(helper);


                    buslicence.setText("");
                    codename.setText("");
                    capacity.setText("");
                    busDname.setText("");
                    contactNumber.setText("");
                    autoCompleteTextView1.setText("");
                    Toast.makeText(getActivity().getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}
