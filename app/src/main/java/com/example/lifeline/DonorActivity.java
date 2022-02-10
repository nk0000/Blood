package com.example.lifeline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DonorActivity extends AppCompatActivity {

    ListView list;
    Button btnRequest;
    String[] maintitle ={
            "Nikhil Kaushik","Simran Hoon", "Aniket Balain","Souvik Saha", "Pritosh Kumar", "Shikhar","Mridul", "Simran Hoon","Anant Kumar",
            "Pritosh Kumar", "Nikhil Kaushik","Abhishek Nain", "Aniket Balain","Souvik Saha", "Pritosh Kumar", "Nikhil Kaushik","Abhishek Nain",
            "Aniket Balain","Souvik Saha", "Pritosh Kumar",
    };

    String[] subtitle ={
            "2 miles","5 miles", "4 miles","7 miles", "8 miles", "2 miles","5 miles", "4 miles","7 miles", "8 miles", "2 miles","5 miles", "4 miles","7 miles", "8 miles", "2 miles","5 miles", "4 miles","7 miles", "8 miles",
    };

    Integer[] imgid={
            R.mipmap.avatar1,R.mipmap.avatar2, R.mipmap.avatar3,R.mipmap.avatar1, R.mipmap.avatar2, R.mipmap.avatar1,R.mipmap.avatar2,
            R.mipmap.avatar3,R.mipmap.avatar1, R.mipmap.avatar2, R.mipmap.avatar1,R.mipmap.avatar2, R.mipmap.avatar3,R.mipmap.avatar1, R.mipmap.avatar2,
            R.mipmap.avatar1,R.mipmap.avatar2, R.mipmap.avatar3,R.mipmap.avatar1, R.mipmap.avatar2,
    };

    public void CallHim(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:8427035456"));
        startActivity(intent);
    }
    public void ViewProfile(View view)
    {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list);
        btnRequest= (Button) findViewById(R.id.btnRequest);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void GoSearch(View view) {
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }


    public void Request(View view) {
        if( btnRequest.getText().equals("Make Request")) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked

                            Toast.makeText(DonorActivity.this, "You requested for A+ blood type!",
                                    Toast.LENGTH_LONG).show();
                            btnRequest.setText("Request Status");
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }

            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
        }
        else {
            Intent intent = new Intent(DonorActivity.this,StatusActivity.class);
            startActivity(intent);
        }
    }
    public void MyProfile(View view) {
        Intent intent = new Intent(DonorActivity.this, AccountActivity.class);
        startActivity(intent);
    }
}