package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;
import static com.example.myapplication.R.layout.activity_main3;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> firstname;
    private ArrayList<String> cid ;
    private ArrayList<String> lastname;
    private ArrayList<String> age;
    private ArrayList<String> gender;
    private ArrayList<String> balance_amount;

    public RecyclerAdapter(Context context, ArrayList<String> firstname, ArrayList<String> cid, ArrayList<String> lastname, ArrayList<String> age, ArrayList<String> gender, ArrayList<String> balance_amount) {
        this.context = context;
        this.firstname = firstname;
        this.cid = cid;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.balance_amount = balance_amount;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(activity_main3, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String fname = firstname.get(position);
        holder.first_name.setText(fname);
        String lname = lastname.get(position);
        holder.last_name.setText(lname);
        String remamount = balance_amount.get(position);
        holder.amount.setText(remamount);
    }


    @Override
    public int getItemCount() {
        return firstname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView first_name;
        public TextView last_name;
        public TextView amount;
        public ImageView profilepic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            first_name = itemView.findViewById(R.id.first_name);
            last_name = itemView.findViewById(R.id.last_name);
            amount = itemView.findViewById(R.id.amount);
            profilepic = itemView.findViewById(R.id.profilepic);
            profilepic.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition();
            //System.out.println(firstname.get(position));
            Intent i = new Intent(context, DetailsPage.class);
            i.putExtra("firstname",firstname.get(position) );
            i.putExtra("lastname", lastname.get(position));
            i.putExtra("age", age.get(position));
            i.putExtra("gender", gender.get(position));
            i.putExtra("amount", balance_amount.get(position));
            context.startActivity(i);
        }
    }
}
