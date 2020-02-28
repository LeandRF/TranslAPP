package com.example.stt;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ShowFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_file);

        EditText editTextView = findViewById(R.id.editText);

        try {
            InputStreamReader file=new InputStreamReader(getApplicationContext().openFileInput("config.txt"));
            BufferedReader br = new BufferedReader(file);
            String line = br.readLine();
            String text="";
            while (line != null)
            {
                text = text + line + "\n";
                line = br.readLine();
            }
            br.close();
            file.close();
            editTextView.setText(text);

        }
        catch (IOException e) {
            Log.e("Exception", "File read failed: " + e.toString());
        }
    }
}
