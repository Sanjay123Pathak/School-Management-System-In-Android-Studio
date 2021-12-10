package com.example.schoolmanagementsystemapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystemapp.ModalClasses.ResultsModal;
import com.example.schoolmanagementsystemapp.R;

import java.util.ArrayList;

public class ResultsAdapter  extends RecyclerView.Adapter<ResultsAdapter.ResultViewHolder> {
    Context context;
    ArrayList<ResultsModal> resultsList;

    public ResultsAdapter(Context context, ArrayList<ResultsModal> resultsModalsList) {
        this.context = context;
        this.resultsList = resultsModalsList;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.results_details, parent,
                false);
        return  new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        ResultsModal resultsModal=resultsList.get(position);

  holder.tName.setText(resultsModal.getTermName());
  holder.tCgpa.setText(resultsModal.getT_CGPA());
  holder.tCourse.setText(resultsModal.getTCourses());
  holder.tCourseName.setText(resultsModal.getTSubName());
  holder.tGrades.setText(resultsModal.getTGrades());
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public  class ResultViewHolder extends RecyclerView.ViewHolder {
        TextView  tName,tCgpa,tCourse,tCourseName,tGrades;
        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            tName=itemView.findViewById(R.id.semTxt);
            tCgpa=itemView.findViewById(R.id.semCGPA);
            tCourse=itemView.findViewById(R.id.courses);
            tCourseName=itemView.findViewById(R.id.courseNames);
            tGrades=itemView.findViewById(R.id.grades);
        }
    }
}
