package com.example.schoolmanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;
import android.widget.ListView;

import com.example.schoolmanagementsystemapp.Adapters.FeeAdapter;
import com.example.schoolmanagementsystemapp.ModalClasses.FeeModals;

import java.util.ArrayList;

public class FeeStructureActivity extends AppCompatActivity {
ListView feeListView;
ArrayList<FeeModals> feeModalsArrayList;
FeeAdapter adapter;
String feeBal[]={"10000","20000","1250","2000","1500","10000","20000","1250","2000","1500"};
String feeDate[]={"12/12/2021","10/12/2021","02/05/2020","6/06/2020","10/10/2021","12/12/2021","10/12/2021",
        "02/05/2020","6/06/2020","10/10/2021"};
String feeAmt[]={"10000","20000","1250","2000","1500","10000","20000","1250","2000","1500"};
String feeYear[]={"4th","3rd","2nd","1st","2nd","4th","3rd","2nd","1st","2nd"};
String feeSem[]={"6th","7th","5th","8th","7th","6th","7th","5th","8th","7th"};
String feeCrDr[]={"Cr","Dr","Dr","Cr","Dr","Cr","Dr","Dr","Cr","Dr"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_structure);
        feeListView=findViewById(R.id.FeeListView);
        feeModalsArrayList= new ArrayList<>();
        for (int a=0;a<feeBal.length;a++){
            feeModalsArrayList.add(new FeeModals(feeBal[a],feeDate[a],feeAmt[a],feeYear[a],feeSem[a],feeCrDr[a]));
        }
        adapter= new FeeAdapter(getApplicationContext(),R.layout.fee_layout,feeModalsArrayList);
        feeListView.setAdapter(adapter);

    }
}