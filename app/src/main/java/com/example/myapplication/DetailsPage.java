package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsPage extends AppCompatActivity {
    private String firstname;
    private String balance_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        // Fetching values from intent
        Intent i = getIntent();
        firstname = i.getStringExtra("firstname");
        String lastname = i.getStringExtra("lastname");
        String age = i.getStringExtra("age");
        String gender = i.getStringExtra("gender");
        balance_amount = i.getStringExtra("amount");

        ////////////////////////////////

        //finding views
        TextView fname = findViewById(R.id.details_firstname);
        TextView lname = findViewById(R.id.textView4);
        TextView dage = findViewById(R.id.textView8);
        TextView dgender = findViewById(R.id.textView9);
        TextView damount = findViewById(R.id.textView11);

        ////////////
        fname.setText(firstname);
        lname.setText(lastname);
        dage.setText(age);
        dgender.setText(gender);
        damount.setText(balance_amount);
    }

    public void makePayment(View view) {
        EditText transaction_amount  = findViewById(R.id.transaction_amount);
        int inc_amount  = Integer.parseInt(transaction_amount.getText().toString());
        balance_amount = String.valueOf(Integer.parseInt(balance_amount)+inc_amount);
        Customerdb dbhelper = new Customerdb(this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("account_balance", balance_amount);
        db.update("customer_details", values, "first_name =? ", new String[]{firstname});
        Intent i = new Intent(DetailsPage.this, AnimationPage.class);
        startActivity(i);

    }

}