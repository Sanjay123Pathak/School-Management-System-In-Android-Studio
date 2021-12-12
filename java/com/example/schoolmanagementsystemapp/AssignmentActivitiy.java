package com.example.schoolmanagementsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.schoolmanagementsystemapp.Adapters.AssignmentAdapter;
import com.example.schoolmanagementsystemapp.ModalClasses.AssignmentModals;

import java.nio.channels.AsynchronousChannel;
import java.util.ArrayList;

public class AssignmentActivitiy extends AppCompatActivity {
ListView assListView;
ArrayList<AssignmentModals>aList ;
AssignmentAdapter assignmentAdapter;

        String corName[]={"CSE226","INT222","CSE418","CSE306","INT306","CSE101"};
        String assType[]={"Online ","Offline","Online ","Offline","Online ","Offline"};
        String assMarks[]={"30","28","27","30","25","30"};
        String assRes[]={"100 ","93","96","90","86","100"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_activitiy);
        assListView=findViewById(R.id.assignmentListView);
//        getSupportActionBar().setTitle("Assignments");

        aList= new ArrayList<>();
        for (int cnt=0;cnt<corName.length;cnt++){
            aList.add(new AssignmentModals(corName[cnt],assType[4],assMarks[2],assRes[5]));
        }
        assignmentAdapter= new AssignmentAdapter(getApplicationContext(),R.layout.assignment_layout,aList);
        assListView.setAdapter(assignmentAdapter);
    }
}