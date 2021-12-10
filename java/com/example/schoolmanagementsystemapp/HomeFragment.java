package com.example.schoolmanagementsystemapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolmanagementsystemapp.Adapters.MyRecyclerAdapter;
import com.example.schoolmanagementsystemapp.ModalClasses.MyRecyclerViewModal;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    //
    View view;
    RecyclerView myRecyclerView;
    ArrayList<MyRecyclerViewModal> arrayList;
    MyRecyclerAdapter recyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        InitializeData();

//        name and image
        String nameList[]={"Faculty","Students","Announcement","Results","Assignments","Fee Structure"};

        int imageList[] =   {R.drawable.lpu1,R.drawable.lpu2,R.drawable.lpu3,
                             R.drawable.lpu4,R.drawable.lpu5,R.drawable.lpu6};

//        setting the adapter here now

        arrayList = new ArrayList<>();
        for (int count = 0; count < imageList.length; count++) {
            arrayList.add(new MyRecyclerViewModal(nameList[count], imageList[count]));
        }
        recyclerAdapter = new MyRecyclerAdapter(getContext(),arrayList);
        recyclerAdapter.setHasStableIds(true);
        myRecyclerView.setAdapter(recyclerAdapter);

        //set layout manager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
//
        myRecyclerView.setLayoutManager(gridLayoutManager);



        return view;
    }

    public void InitializeData() {
        myRecyclerView = view.findViewById(R.id.myRecyclerView);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.searchIcon);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setQueryHint("Search Here");
        // expanding the searchView
        searchView.setIconified(false);
        searchView.setIconifiedByDefault(false);// false means search icon is set by default on action bar having no text
// this is used for the setting searchHint color and setText green
        SearchView.SearchAutoComplete searchAutoComplete=(SearchView.SearchAutoComplete)
                searchView.findViewById(androidx.appcompat.R.id.search_src_text);
                 searchAutoComplete.setTextColor(Color.GREEN);
                 searchAutoComplete.setHintTextColor(Color.YELLOW);
//        searchView.setBackgroundColor(Color.WHITE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}

