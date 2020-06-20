package com.js.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class mbtiscreenActivity extends AppCompatActivity {

    BookDatabase database;
    ListView listview;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtiscreen);

        // open database
        if (database != null) {
            database.close();
            database = null;
        }

        listview = (ListView)findViewById(R.id.listview);

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
            str.add(result.get(i).getAuthor() + result.get(i).getName() );
        }

        Descending descending = new Descending();
        Collections.sort(str, descending);

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
