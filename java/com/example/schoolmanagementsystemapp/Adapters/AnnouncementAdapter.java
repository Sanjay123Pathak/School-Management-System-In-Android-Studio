package com.example.schoolmanagementsystemapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystemapp.ModalClasses.AnnouncementModal;
import com.example.schoolmanagementsystemapp.R;

import java.util.ArrayList;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder> {

    Context context;
    ArrayList<AnnouncementModal> arrayList;

    public AnnouncementAdapter(Context context, ArrayList<AnnouncementModal> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_details, parent,
                false);
        return new AnnouncementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
        AnnouncementModal announcementModal=arrayList.get(position);
        holder.annType.setText(announcementModal.getAnnType());
        holder.annDate.setText(announcementModal.getAnnDate());
        holder.annMsg.setText(announcementModal.getAnnMessage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class AnnouncementViewHolder extends RecyclerView.ViewHolder {
      TextView annType,annDate,annMsg;
        public AnnouncementViewHolder(@NonNull View itemView) {
            super(itemView);
            annType=itemView.findViewById(R.id.annType);
            annDate=itemView.findViewById(R.id.annDate);
            annMsg=itemView.findViewById(R.id.annMsg);
        }
    }
}
