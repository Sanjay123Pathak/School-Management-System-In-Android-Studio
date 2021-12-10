package com.example.schoolmanagementsystemapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.schoolmanagementsystemapp.Adapters.FacultyAdapter;
import com.example.schoolmanagementsystemapp.Adapters.StudentAdapter;
import com.example.schoolmanagementsystemapp.ModalClasses.FacultyModal;
import com.example.schoolmanagementsystemapp.ModalClasses.StudentModal;

import java.util.ArrayList;
import java.util.List;


public class StudentDetailFragment extends Fragment {
    RecyclerView stud_RecyclerView;
    List<StudentModal> studList;
    StudentAdapter studentAdapter;
    private  String[] nameArr={"Sanjay","Anil","Santosh","Dharmendar","Rabinder"};
    private  int[] regArr={112345,434534,123432,116780,231254};
    private String[] secArr={"KOM09","KMO23","RKM09","KE173","K18FR"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Students List");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_detail, container, false);


        stud_RecyclerView=view.findViewById(R.id.Student_RecyclerView);
        studList= new ArrayList<>();

        for (int i=0;i<nameArr.length;i++){
            studList.add(new StudentModal(R.drawable.lpu6,nameArr[i],regArr[i],secArr[i]));
        }

        studentAdapter= new StudentAdapter(getContext(),studList);

        stud_RecyclerView.setAdapter(studentAdapter);
        LinearLayoutManager lm= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);
        stud_RecyclerView.setLayoutManager(lm);


        return  view;
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_add_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.studentSearch);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setQueryHint("Search Here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                studentAdapter.getFilter().filter(newText);
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }
// for adding new students
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addStudents:
                Toast.makeText(getContext(), "Add is clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}