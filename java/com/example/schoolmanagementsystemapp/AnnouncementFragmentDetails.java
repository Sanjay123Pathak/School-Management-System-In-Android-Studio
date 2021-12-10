package com.example.schoolmanagementsystemapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolmanagementsystemapp.Adapters.AnnouncementAdapter;
import com.example.schoolmanagementsystemapp.ModalClasses.AnnouncementModal;

import java.util.ArrayList;


public class AnnouncementFragmentDetails extends Fragment {

 RecyclerView annRecyclerView;
 AnnouncementAdapter announcementAdapter;
 ArrayList<AnnouncementModal> modalArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Announcements");
        // Inflate the layout for this fragment
        View annView=inflater.inflate(R.layout.fragment_announcement_details, container, false);
        annRecyclerView=annView.findViewById(R.id.annRecyclerview);
        modalArrayList= new ArrayList<>();
        for (int i=0;i<5;i++){
            modalArrayList.add(new AnnouncementModal("Education","24 Oct",
                    "Today is Sunday and happy Karwa chauth to every One"));
        }
        announcementAdapter= new AnnouncementAdapter(getContext(),modalArrayList);
        annRecyclerView.setAdapter(announcementAdapter);
        LinearLayoutManager lm= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);
        annRecyclerView.setLayoutManager(lm);
        return  annView;
    }
}