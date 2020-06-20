package com.js.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.EditText;

import java.util.ArrayList;

public class registerscreenActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MENU = 101;
    private static final String KEY_USER_DATA = "data";

    BookDatabase database;

    EditText editText;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerscreen);

        editText = findViewById(R.id.editText6);
        editText2 = findViewById(R.id.editText7);
        editText3 = findViewById(R.id.editText8);

        // open database
        if (database != null) {
            database.close();
            database = null;
        }

        database = BookDatabase.getInstance(this);
        boolean isOpen = database.open();
        if (isOpen) {

        } else {

        }

        Button registerbtn =findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String author = editText2.getText().toString();
                String contents = editText3.getText().toString();

                database.insertRecord(name, author, contents);
                Toast.makeText(getApplicationContext(), "등록되었습니다", Toast.LENGTH_LONG).show();

            }
        });


    }
}
