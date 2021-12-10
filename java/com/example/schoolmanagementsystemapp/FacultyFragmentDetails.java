package com.example.schoolmanagementsystemapp;

import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolmanagementsystemapp.Adapters.FacultyAdapter;
import com.example.schoolmanagementsystemapp.ModalClasses.FacultyModal;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragmentDetails extends Fragment {
RecyclerView fRecyclerView;
List<FacultyModal> list;
FacultyAdapter facultyAdapter;
String[] facultyNames={"Ravi Sharma","Sanjay Pathak","Navpreet Kaur"," Sahil Sharma","Ankur Barma",
      "Parapreet Kaur","Amrainder Kaur"};
String[] facultyDept={"ECE Dept","CSE Dept","MEC Dept", "Civil Dept","Bio Dept","Physics Dept","Chemistry Dept"};
//    List<FacultyModal> addDeletedList= new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Faculty List");

        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_faculty_details, container, false);
        fRecyclerView=v.findViewById(R.id.fRecyclerView);
        list= new ArrayList<>();
        for (int count=0;count<facultyNames.length;count++){
            list.add(new FacultyModal(R.drawable.lpu3,facultyNames[count], facultyNames[count]));
        }
        facultyAdapter= new FacultyAdapter(getContext(),list);
        fRecyclerView.setAdapter(facultyAdapter);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);
        fRecyclerView.setLayoutManager(linearLayoutManager);


        // calling the simple call back
        ItemTouchHelper itemTouchHelper= new ItemTouchHelper(simpleCallback);
        // attaching the itemTouchListener to recycler view
        itemTouchHelper.attachToRecyclerView(fRecyclerView);

        return  v;
    }

    // simple call back for deleting item from recyclerview
    ItemTouchHelper.SimpleCallback simpleCallback= new ItemTouchHelper.SimpleCallback(0,
            ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                              @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            // use swipe feature here now
          final   int position= viewHolder.getAdapterPosition();//getting the position of the row or viewHolder
            switch (direction) {
                case ItemTouchHelper.LEFT:

                    list.remove(position);//removing items from list
                    facultyAdapter.notifyItemRemoved(position);// notifying the adapter that item is removed anf refresh it


                    break;
                case ItemTouchHelper.RIGHT:
                    // do nothing
                    break;
            }
        }


    };
}