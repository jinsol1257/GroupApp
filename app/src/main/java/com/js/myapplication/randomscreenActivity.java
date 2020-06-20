package com.js.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class randomscreenActivity extends AppCompatActivity {

    BookDatabase database;

    ListView listview;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomscreen);


        listview = (ListView)findViewById(R.id.listview);

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

        Button analyzebtn =findViewById(R.id.analyzebtn);
        analyzebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                readList();
            }
        });

    }
    void readList(){


        editText3 = findViewById(R.id.editText6);

        int spt =  Integer.parseInt( editText3.getText().toString() );


        final ArrayList<UserInfo> result = database.selectAll();
        final ArrayList<String> str = new ArrayList();
        for (int i = 0; i < result.size() ; i++) {
            str.add("n"+i+":"+ result.get(i).getName() );
        }

        for( int i=0;i<str.size() ; i++){
            int n = (int)(Math.random()*str.size());
            String a = str.get(n);
            String f = str.get(i);
            str.set(i, a);
            str.set( n, f );
        }

        int t = str.size() ;
        int n=0;
        for(int i=spt ;i< t ; i+= spt ){
            str.add( i+n,"====================");
            n++;
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,
                str
        );
        listview.setAdapter(adapter);
    }

}
