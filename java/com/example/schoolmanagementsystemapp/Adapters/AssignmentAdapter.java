package com.example.schoolmanagementsystemapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.schoolmanagementsystemapp.ModalClasses.AssignmentModals;
import com.example.schoolmanagementsystemapp.R;

import java.util.ArrayList;

public class AssignmentAdapter extends ArrayAdapter<AssignmentModals>{
    Context context;
    ArrayList<AssignmentModals> arrayList;


    public AssignmentAdapter( Context context, int textViewResourceId,ArrayList<AssignmentModals>arrList) {
        super(context, textViewResourceId, arrList);
        this.context=context;
        arrayList=arrList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public int getPosition( AssignmentModals item) {
        return super.getPosition(item);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.assignment_layout,null);
        Button assDownload=v.findViewById(R.id.assDownload);
        assDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "File is downloading now ...", Toast.LENGTH_SHORT).show();
            }
        });
        return  v;
    }
}
