package com.example.lifeline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountActivity extends AppCompatActivity {
    EditText edt_name,edt_bloodgroup,edt_gender,edt_location;
    Button btn_save;

    DatabaseReference reff;
    long maxid = 0;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        edt_name = findViewById(R.id.edt_name);
        edt_bloodgroup = findViewById(R.id.edt_bloodgroup);
        edt_gender = findViewById(R.id.edt_gender);
        edt_location = findViewById(R.id.edt_location);

        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    maxid = snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void Save(View view) {

        String name = edt_name.getText().toString().trim();
        String bloodgroup = edt_bloodgroup.getText().toString().trim();
        String gender = edt_gender.getText().toString().trim();
        String location = edt_location.getText().toString().trim();

        member.setName(name);
        member.setBloodgroup(bloodgroup);
        member.setGender(gender);
        member.setLocation(location);

        reff.child(String.valueOf(maxid+1)).setValue(member);

        Toast.makeText(AccountActivity.this, "Information saved!",
                Toast.LENGTH_LONG).show();
    }
    public void MyProfile(View view)
    {
        Intent intent = new Intent(this,AccountActivity.class);
        startActivity(intent);
    }
}