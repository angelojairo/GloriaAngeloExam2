package com.gloria.gloriaangeloexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Confirmation extends AppCompatActivity {
    TextView c,c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        setTitle("REGISTRATION");
        c = findViewById(R.id.textView6);
        c2 = findViewById(R.id.textView7);
        FileInputStream reader = null;
        FileInputStream reader2 = null;
        String data = "";
        String data2 = "";
        try {
            reader = openFileInput("data1.txt");
            reader2 = openFileInput("data2.txt");
            int token;
            while((token = reader.read()) != -1){
                data = data + (char)token;
            }
            while((token = reader2.read()) != -1){
                data2 = data2 + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("error","File note found...");
        } catch (IOException e) {
            Log.d("error","IO error...");
        }

        String toSplit[] = data.split("-");
        for(int i = 0; i<toSplit.length; i++){
            c.append(toSplit[i]+"\n");
        }
        c2.append(data2);
    }

    public void prev(View v){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
}

    public void toast(View v){
        setTitle("SUMMARY");
        Toast.makeText(this,"Registration Sent...",Toast.LENGTH_LONG).show();
    }
}
