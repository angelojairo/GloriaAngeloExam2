package com.gloria.gloriaangeloexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox c3,c7,c10,c9,c8,c6,c5,c4;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ACTIVITY REGISTRAION");
        c3 = findViewById(R.id.checkBox3);
        c7 = findViewById(R.id.checkBox7);
        c10 = findViewById(R.id.checkBox10);
        c9 = findViewById(R.id.checkBox9);
        c8 = findViewById(R.id.checkBox8);
        c6 = findViewById(R.id.checkBox6);
        c5 = findViewById(R.id.checkBox5);
        c4 = findViewById(R.id.checkBox4);
        e1 = findViewById(R.id.editText);
    }

    public void writeData(View v){
        String data3 = c3.getText().toString();
        String data7 = c7.getText().toString();
        String data10 = c10.getText().toString();
        String data9 = c9.getText().toString();
        String data8 = c8.getText().toString();
        String data6 = c6.getText().toString();
        String data5 = c5.getText().toString();
        String data4 = c4.getText().toString();
        String comment = e1.getText().toString();

        String stringToSplit = "";

        if(c3.isChecked()){
            stringToSplit = stringToSplit + data3 + "-";
        }
        if(c7.isChecked()){
            stringToSplit = stringToSplit + data7 + "-";
        }
        if(c10.isChecked()){
            stringToSplit = stringToSplit + data10 + "-";
        }
        if(c9.isChecked()){
            stringToSplit = stringToSplit + data9 + "-";
        }
        if(c8.isChecked()){
            stringToSplit = stringToSplit + data8 + "-";
        }
        if(c6.isChecked()){
            stringToSplit = stringToSplit + data6 + "-";
        }
        if(c5.isChecked()){
            stringToSplit = stringToSplit + data5 + "-";
        }
        if(c4.isChecked()){
            stringToSplit = stringToSplit + data4 + "-";
        }

        FileOutputStream writer = null;
        FileOutputStream writer1 = null;
        try {
            writer = openFileOutput("data1.txt",MODE_PRIVATE);
            writer1 = openFileOutput("data2.txt",MODE_PRIVATE);
            writer.write(stringToSplit.getBytes());
            writer1.write(comment.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error","File note found ...");
        } catch (IOException e) {
            Log.d("error","IO error...");
        }finally {
            try {
                writer.close();
                writer1.close();
            } catch (IOException e) {
                Log.d("error","File not found ...");
            }
        }

        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show();
    }
    public void next(View v){
        Intent i = new Intent(getApplicationContext(),Confirmation.class);
        startActivity(i);
    }
}
