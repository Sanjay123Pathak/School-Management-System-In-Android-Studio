package com.example.schoolmanagementsystemapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.schoolmanagementsystemapp.ModalClasses.AssignmentModals;
import com.example.schoolmanagementsystemapp.ModalClasses.FeeModals;
import com.example.schoolmanagementsystemapp.R;

import java.util.ArrayList;

public class FeeAdapter extends ArrayAdapter<FeeModals> {
    Context context;
    ArrayList<FeeModals> arrayList1;

    public FeeAdapter(Context context, int textViewResourceId, ArrayList<FeeModals> arrayList) {
        super(context,textViewResourceId,arrayList);

        this.context = context;
        arrayList = arrayList1;
    }

    @Override
    public int getPosition(@Nullable FeeModals item) {
        return super.getPosition(item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.fee_layout, null);

        return v;
    }
}