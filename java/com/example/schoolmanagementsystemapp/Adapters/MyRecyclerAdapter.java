package com.example.schoolmanagementsystemapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolmanagementsystemapp.AnnouncementFragmentDetails;
import com.example.schoolmanagementsystemapp.FacultyFragmentDetails;
import com.example.schoolmanagementsystemapp.ModalClasses.MyRecyclerViewModal;
import com.example.schoolmanagementsystemapp.R;
import com.example.schoolmanagementsystemapp.ResultsDetailsFragment;
import com.example.schoolmanagementsystemapp.StudentDetailFragment;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerViewHolder> implements Filterable {
    Context context;
    ArrayList<MyRecyclerViewModal> list;
    ArrayList<MyRecyclerViewModal> backUpListForSearching;
    Fragment fragment=null;

    public MyRecyclerAdapter(Context context,ArrayList<MyRecyclerViewModal> list) {
        this.context = context;
        this.list = list;
        backUpListForSearching= new ArrayList<>(list);
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_recycler_view_modal_layout, parent,
                false);
        return new MyRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {


        MyRecyclerViewModal myRecyclerViewModal = list.get(position);
        holder.imageView.setImageResource(myRecyclerViewModal.getImages());
        holder.nameText.setText(myRecyclerViewModal.getNameItem());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String itemPosition=myRecyclerViewModal.getNameItem();
               switch (itemPosition){
                   case "Faculty":
                       Toast.makeText(context, itemPosition, Toast.LENGTH_SHORT).show();
                       fragment= new FacultyFragmentDetails();
                       loadFragment(fragment);

//                   ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

                       break;
                   case "Students":
                       Toast.makeText(context, itemPosition, Toast.LENGTH_SHORT).show();
                       fragment= new StudentDetailFragment();
                       loadFragment(fragment);
                       break;
                   case "Announcement":
                       Toast.makeText(context, itemPosition, Toast.LENGTH_SHORT).show();
                       fragment= new AnnouncementFragmentDetails();
                       loadFragment(fragment);
                       break;

                   case "Results":
                       Toast.makeText(context, itemPosition, Toast.LENGTH_SHORT).show();
                       fragment= new ResultsDetailsFragment();
                       loadFragment(fragment);
                       break;
                   case "Assignments":
                       Toast.makeText(context, itemPosition, Toast.LENGTH_SHORT).show();


                       break;
                   case "Fee Structure":
                       Toast.makeText(context, itemPosition, Toast.LENGTH_SHORT).show();

                       break;
                   default:

               }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


// here I have implemented click listener on the views of recycler view
    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        CircleImageView imageView;
        TextView nameText;

        public MyRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            nameText = itemView.findViewById(R.id.myCardText);
            imageView = itemView.findViewById(R.id.myCardImage);

        }


    }

    // this is for filtering the search items
    @Override
    public Filter getFilter() {
        return filterItems;
    }
    private  Filter filterItems= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence key) {
            ;
            //whenever you search the items it will returns something so We should store it in arrayList;
            ArrayList<MyRecyclerViewModal>data1= new ArrayList<>();
            if (key.toString().isEmpty()){
                // nothing is searched then returns the whole  BackUpList  to the newly created list

                 data1.addAll(backUpListForSearching);

            }
            else {
                for (MyRecyclerViewModal obj:backUpListForSearching){
                    if (obj.getNameItem().toLowerCase().contains(key)){
                        data1.add(obj);
                    }
                }
            }
            FilterResults filterResults= new FilterResults();
            filterResults.values=data1;
            return filterResults;// this values is going to line no 105
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
              list.clear();
              list.addAll((ArrayList<MyRecyclerViewModal>) results.values);
              notifyDataSetChanged();
        }
    };


    public  void loadFragment(Fragment fg){
        FragmentManager fragmentManager= ((AppCompatActivity)context).getSupportFragmentManager();
//        backCount=fragmentManager.getBackStackEntryCount();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fg);
        fragmentTransaction.addToBackStack(null).commit();
    }
}
