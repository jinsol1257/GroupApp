package com.js.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn5;
    Button randombtn;
    Button listbtn;
    Button mbtibtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_mainlayout);

        btn5 =findViewById(R.id.btn5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, registerscreenActivity.class);
                startActivity(intent);
            }
        });

        btn1 =findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, listcreenActivity.class);
                startActivity(intent);
            }
        });

        listbtn =findViewById(R.id.btn1);

        listbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, listcreenActivity.class);
                startActivity(intent);
            }
        });

        randombtn =findViewById(R.id.randombtn);

        randombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, randomscreenActivity.class);
                startActivity(intent);
            }
        });

        mbtibtn =findViewById(R.id.mbtibtn);

        mbtibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, mbtiscreenActivity.class);
                startActivity(intent);
            }
        });



    }

}
