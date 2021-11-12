package com.example.myfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayAdapter<String> adapter;
    String tag = "FIREBASE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        lvContact = findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter);
        //get firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //connect
        DatabaseReference myRef = database.getReference("contacts");
        // listener
        myRef.addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot snapShot) {
                adapter.clear();
                //loop to get data whenever firebase changed

                for(DataSnapshot data: snapShot.getChildren()){
                    String key = data.getKey();

                    String value = data.getValue().toString();
                    adapter.add(key + "\n" + value);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(tag,"loadPost:onCancelled", error.toException());
            }
        });

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id) {
                String data = adapter.getItem(position);
                String key = data.split("\n")[0];
                Intent intent = new Intent(MainActivity.this,UpdateContact.class);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId()== R.id.mi_addContact){
            Intent intent = new Intent(MainActivity.this,AddContact.class);
            String data = adapter.getItem(adapter.getCount() -1);
            String str_Id = data.split("\n")[0];
            intent.putExtra("id",str_Id);
            startActivity(intent);
        }else if(item.getItemId() == R.id.mnuLogin){
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.mnuRegister){
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

}