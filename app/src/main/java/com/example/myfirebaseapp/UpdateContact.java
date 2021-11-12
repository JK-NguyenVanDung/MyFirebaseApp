package com.example.myfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UpdateContact extends AppCompatActivity {
    EditText id,name,gender,email,address,mobileP,homeP,officeP;
    Button update,cancel,delete;
    private String str_Id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);
        matching();
        getContactDetail();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContactDetail();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();

            }
        });
    }
    private void deleteContact() {
        FirebaseDatabase database =  FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("contacts");
        reference.child(str_Id).removeValue();
        Toast.makeText(getApplicationContext(), "Delete successful " + str_Id, Toast.LENGTH_SHORT).show();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finish();

    }
    private void getContactDetail() {
        Intent intent = getIntent();


        final String key = intent.getStringExtra("key");
        str_Id = key;
        FirebaseDatabase database =  FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("contacts");


        reference.child(key).addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try{
                    HashMap<String,Object> hashMap = (HashMap<String,Object>) snapshot.getValue();
                    id.setText(key);
                    id.setFocusable(false);
                    name.setText(hashMap.get("name").toString());
                    gender.setText(hashMap.get("gender").toString());
                    email.setText(hashMap.get("email").toString());
                    address.setText(hashMap.get("address").toString());
                    mobileP.setText(hashMap.get("mobile").toString());
                    homeP.setText(hashMap.get("home").toString());
                    officeP.setText(hashMap.get("office").toString());

                }catch( Exception e){
                    Log.d("JSON_ERROR",e.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("DETAIL_ERROR","loadPost:onCancelled",error.toException());

            }
        });

    }
    private void updateContactDetail(){
        try{
            String str_Name = name.getText().toString().trim();
            String str_Gender = gender.getText().toString().trim();
            String str_Email = email.getText().toString().trim();
            String str_Address = address.getText().toString().trim();
            String str_MobileP = mobileP.getText().toString().trim();
            String str_HomeP = homeP.getText().toString().trim();
            String str_OfficeP = officeP.getText().toString().trim();
            if( TextUtils.isEmpty(str_Name) || TextUtils.isEmpty(str_Gender)
                    || TextUtils.isEmpty(str_Email) || TextUtils.isEmpty(str_Address)
                    || TextUtils.isEmpty(str_MobileP) || TextUtils.isEmpty(str_HomeP)
                    || TextUtils.isEmpty(str_OfficeP)
            ){
                Toast.makeText(getApplicationContext(), "No empty field allowed!", Toast.LENGTH_SHORT).show();

            }else{
                FirebaseDatabase database =  FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("contacts");
                reference.child(str_Id).child("name").setValue(str_Name);
                reference.child(str_Id).child("email").setValue(str_Email);
                reference.child(str_Id).child("gender").setValue(str_Gender);
                reference.child(str_Id).child("address").setValue(str_Address);
                reference.child(str_Id).child("mobile").setValue(str_MobileP);
                reference.child(str_Id).child("home").setValue(str_HomeP);
                reference.child(str_Id).child("office").setValue(str_OfficeP);
                Toast.makeText(getApplicationContext(), "Update successful " + str_Id, Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }

        }catch(Exception e){
            Log.d("Error add",e.toString());
        }
    }
    private void matching(){
        id= findViewById(R.id.et_Id_up);
        name= findViewById(R.id.et_name_up);
        gender= findViewById(R.id.et_gender_up);
        email= findViewById(R.id.et_email_up);
        address= findViewById(R.id.et_address_up);
        mobileP= findViewById(R.id.et_mobile_up);
        homeP= findViewById(R.id.et_home_up);
        officeP= findViewById(R.id.et_office_up);
        update= findViewById(R.id.btn_update);
        cancel= findViewById(R.id.btn_cancel_update);
        delete = findViewById(R.id.btn_delete);
    }
}