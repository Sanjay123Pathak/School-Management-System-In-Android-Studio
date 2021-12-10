package com.example.schoolmanagementsystemapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolmanagementsystemapp.Adapters.ResultsAdapter;
import com.example.schoolmanagementsystemapp.ModalClasses.ResultsModal;

import java.util.ArrayList;


public class ResultsDetailsFragment extends Fragment {
RecyclerView resRecyclerView;
 ArrayList<ResultsModal>arrayList;
 ResultsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View resView=inflater.inflate(R.layout.fragment_results_details, container, false);
        resRecyclerView=resView.findViewById(R.id.resRecyclerView);
         arrayList= new ArrayList<>();
         for(int i=1;i<5;i++) {
             arrayList.add(new ResultsModal("Term V", "7.54", "CSE225", "Android Development", "A+"));
         }
         adapter= new ResultsAdapter(getContext(),arrayList);

         resRecyclerView.setAdapter(adapter);
        LinearLayoutManager lm= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);
        resRecyclerView.setLayoutManager(lm);


        return  resView;
    }
}