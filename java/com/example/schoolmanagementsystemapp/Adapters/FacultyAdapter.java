package com.example.schoolmanagementsystemapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystemapp.ModalClasses.FacultyModal;
import com.example.schoolmanagementsystemapp.R;

import java.util.List;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder> {
    Context context;
    List<FacultyModal> fList;

    public FacultyAdapter(Context context, List<FacultyModal> fList) {
        this.context = context;
        this.fList = fList;
    }

    @NonNull
    @Override
    public FacultyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.faculty_member_list,parent,false);
        return  new FacultyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyViewHolder holder, int position) {
     final FacultyModal facultyModal=fList.get(position);
        holder.FImage.setImageResource(facultyModal.getFImage());
        holder.FDept.setText(facultyModal.getFDepartment());
        holder.FName.setText(facultyModal.getFName());

    }

    @Override
    public int getItemCount() {
        return fList.size();
    }

    public class  FacultyViewHolder extends RecyclerView.ViewHolder{
  ImageView FImage;
  TextView FDept,FName;
//  CardView FCardView;
        public FacultyViewHolder(@NonNull View itemView) {
            super(itemView);
            FImage=itemView.findViewById(R.id.facultyImage);
            FDept=itemView.findViewById(R.id.FacultyDepartment);
            FName=itemView.findViewById(R.id.FacultyName);
        }
    }

}
