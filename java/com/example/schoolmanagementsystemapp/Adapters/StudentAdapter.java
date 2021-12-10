package com.example.schoolmanagementsystemapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystemapp.ModalClasses.FacultyModal;
import com.example.schoolmanagementsystemapp.ModalClasses.MyRecyclerViewModal;
import com.example.schoolmanagementsystemapp.ModalClasses.StudentModal;
import com.example.schoolmanagementsystemapp.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> implements Filterable {
    Context context;
    List<StudentModal> studentModalList;
    List<StudentModal> studentSearchList;


    public StudentAdapter(Context context, List<StudentModal> studentModalList) {
        this.context = context;
        this.studentModalList=studentModalList;
        studentSearchList= new ArrayList<>(studentModalList);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_detail_list,parent,false);
        return  new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final StudentModal studentModal=studentModalList.get(position);
        holder.SImage.setImageResource(studentModal.getSImage());
        holder.SName.setText(studentModal.getSName());
        holder.SregNo.setText(String.valueOf(studentModal.getSReg_no()));
        holder.Section.setText(studentModal.getSection());

    }

    @Override
    public int getItemCount() {
        return studentModalList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    private  Filter filter= new Filter(){

        @Override
        protected FilterResults performFiltering(CharSequence key) {
            //whenever you search the items it will returns something so We should store it in arrayList;
            ArrayList<StudentModal>putSearchItemInList= new ArrayList<>();
            if (key.toString().isEmpty()){
                // nothing is searched then returns the whole  BackUpList  to the newly created list

              putSearchItemInList.addAll(studentSearchList);

            }
            else {
                for (StudentModal obj:studentSearchList){

                    if (obj.getSName().toLowerCase().contains(key)
                            || String.valueOf(obj.getSReg_no()).contains(key) ||obj.getSection().toLowerCase().contains(key)){
                        putSearchItemInList.add(obj);
                    }
                }
            }
            FilterResults fr= new FilterResults();
            fr.values=putSearchItemInList;
            return fr;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            studentModalList.clear();
            studentModalList.addAll((ArrayList<StudentModal>) results.values);
            notifyDataSetChanged();
        }
    };


    public class  StudentViewHolder extends RecyclerView.ViewHolder{
        ImageView SImage;
        TextView  SName,SregNo,Section;
        //  CardView FCardView;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            SImage=itemView.findViewById(R.id.SImage);
           SName=itemView.findViewById(R.id.SName);
            SregNo=itemView.findViewById(R.id.SRoll_No);
            Section=itemView.findViewById(R.id.SSection);
        }
    }


}
