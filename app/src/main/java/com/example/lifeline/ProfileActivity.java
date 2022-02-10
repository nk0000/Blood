package com.example.lifeline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;

import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void CallHim(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: 8427035456"));
        startActivity(intent);
    }
    public void MyProfile(View view)
    {
        Intent intent = new Intent(this,AccountActivity.class);
        startActivity(intent);
    }
}
//public class ProfileActivity extends AppCompatActivity {
//Member member;
//TextView tv_name,tv_gender,tv_bloodgroup,tv_location;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//
//        String name = member.getName();
//        String gender = member.getGender();
//        String bloodgroup = member.getBloodgroup();
//        String location = member.getLocation();
//
//        tv_name.setText(name);
//        tv_gender.setText(gender);
//        tv_bloodgroup.setText(bloodgroup);
//        tv_location.setText(location);
//
//    }
//
//    public void CallHim(View view)
//    {
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:8427035456"));
//        startActivity(intent);
//    }
//    public void MyProfile(View view)
//    {
//        Intent intent = new Intent(ProfileActivity.this,AccountActivity.class);
//        startActivity(intent);
//    }
//}
