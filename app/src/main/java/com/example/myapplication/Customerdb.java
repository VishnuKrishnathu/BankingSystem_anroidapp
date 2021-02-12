package com.example.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Customerdb extends SQLiteOpenHelper {

    public Customerdb(@Nullable Context context) {
        super(context, "customer_details.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table customer_details (cid text, first_name text, last_name text, age text, account_balance text, gender text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists customers");
        onCreate(db);
    }
}
