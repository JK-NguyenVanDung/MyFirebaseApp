package com.example.myfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContact extends AppCompatActivity {
    EditText id,name,gender,email,address,mobileP,homeP,officeP;
    Button add,cancel;
    private String str_Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        matching();
        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        if(extras!=null)
        {
            str_Id = extras.getString("id");
            str_Id = Integer.toString(Integer.parseInt(str_Id) + 1);
            id.setText(str_Id);
            id.setFocusable(false);
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAddNew();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void handleAddNew(){
        try{
            String str_Name = name.getText().toString();
            String str_Gender = gender.getText().toString();
            String str_Email = email.getText().toString();
            String str_Address = address.getText().toString();
            String str_MobileP = mobileP.getText().toString();
            String str_HomeP = homeP.getText().toString();
            String str_OfficeP = officeP.getText().toString();
            if( TextUtils.isEmpty(str_Name) || TextUtils.isEmpty(str_Gender)
                    || TextUtils.isEmpty(str_Email) || TextUtils.isEmpty(str_Address)
                    || TextUtils.isEmpty(str_MobileP) || TextUtils.isEmpty(str_HomeP)
                    || TextUtils.isEmpty(str_OfficeP)
            ){
                Toast.makeText(getApplicationContext(), "No empty field allowed!", Toast.LENGTH_SHORT).show();

            }
            else{
                FirebaseDatabase database =  FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("contacts");
                reference.child(str_Id).child("name").setValue(str_Name);
                reference.child(str_Id).child("email").setValue(str_Email);
                reference.child(str_Id).child("gender").setValue(str_Gender);
                reference.child(str_Id).child("address").setValue(str_Address);
                reference.child(str_Id).child("mobile").setValue(str_MobileP);
                reference.child(str_Id).child("home").setValue(str_HomeP);
                reference.child(str_Id).child("office").setValue(str_OfficeP);
                Toast.makeText(getApplicationContext(), "Add successful " + str_Id, Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(1000);
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
        id= findViewById(R.id.et_Id);
        name= findViewById(R.id.et_name);
        gender= findViewById(R.id.et_gender);
        email= findViewById(R.id.et_email);
        address= findViewById(R.id.et_address);
        mobileP= findViewById(R.id.et_mobile);
        homeP= findViewById(R.id.et_home);
        officeP= findViewById(R.id.et_office);
        add= findViewById(R.id.btn_add);
        cancel= findViewById(R.id.btn_cancel);
    }
}