package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<String> firstname = new ArrayList<String>();
    private ArrayList<String> cid = new ArrayList<String>();
    private ArrayList<String> lastname = new ArrayList<String>();
    private ArrayList<String> age = new ArrayList<String>();
    private ArrayList<String> gender = new ArrayList<String>();
    private ArrayList<String> balance_amount = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Customerdb dbhelper = new Customerdb(this);
//        SQLiteDatabase db = dbhelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        String[] cid = {"3", "4", "5", "6", "7", "8", "9", "10"};
//        String[] first_name = {"Meghana", "Manpreet", "Pranab", "Biren", "Dipti", "Madhavi", "Harrison", "Nels"};
//        String[] last_name = {"Hemendra", "Bumb", "Sawant", "Rout", "Mohan", "Kakar", "Laffer", "Dickens"};
//        String[] age = {"36", "56", "35", "30", "26", "32", "49", "26"};
//        String[] account_balance = {"38999", "190976", "50985", "38267", "48909", "78993", "36206", "56783"};
//        String[] gender = {"female", "male", "male", "male", "female", "female", "male", "male"};
//        int i = 0;
//        while(i < cid.length){
//            values.put("cid",cid[i]);
//            values.put("first_name", first_name[i]);
//            values.put("last_name", last_name[i]);
//            values.put("age", age[i]);
//            values.put("account_balance", account_balance[i]);
//            values.put("gender", gender[i]);
//            long row = db.insert("customer_details", null, values);
//            System.out.println(row);
//            i++;
//        }

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String[] projection = {"cid", "first_name", "last_name", "age", "account_balance", "gender"};
        Cursor c = db.query("customer_details", projection, null, null, null, null, null);
        for(int i = 0; i<c.getCount();i++ ){
            c.moveToPosition(i);
            cid.add(c.getString(0));
            firstname.add(c.getString(1));
            lastname.add(c.getString(2));
            age.add(c.getString(3));
            balance_amount.add(c.getString(4));
            gender.add(c.getString(5));
        }
        recyclerAdapter = new RecyclerAdapter(MainActivity2.this, firstname, cid, lastname, age, gender, balance_amount);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
