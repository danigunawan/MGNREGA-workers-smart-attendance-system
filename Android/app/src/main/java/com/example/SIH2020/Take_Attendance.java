package com.example.SIH2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Take_Attendance extends AppCompatActivity {
    Button submit;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take__attendance);
        submit = findViewById(R.id.b1);
        text = findViewById(R.id.text);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    FileOutputStream fos = openFileOutput("xyz", MODE_APPEND);
                    String text1 = text.getText().toString() + "\n";

                    fos.write(text1.getBytes());

                    Toast.makeText(getBaseContext(), "Id is stored in file", Toast.LENGTH_SHORT).show();

                    FileInputStream fileInputStream = openFileInput("xyz.txt");
                    int read = -1;
                    StringBuffer buffer = new StringBuffer();
                    while ((read = fileInputStream.read()) != -1) {
                        buffer.append((char) read);

                    }
                    //Toast.makeText(getBaseContext(), "Stored data :"+buffer, Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(getApplicationContext(), Menu_Activity.class);
                startActivity(i);
                finish();


            }
        });
    }}