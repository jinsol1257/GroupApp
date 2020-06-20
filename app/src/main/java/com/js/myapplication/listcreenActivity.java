package com.js.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class listcreenActivity extends AppCompatActivity {
    BookDatabase database;
    ListView listview;
    private TextView textView;
    private static final String KEY_USER_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcreen);


        listview = (ListView)findViewById(R.id.list1);

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

        final ArrayList<UserInfo> result = database.selectAll();
        final ArrayList<String> str = new ArrayList();
        for (int i = 0; i < result.size() ; i++) {
            str.add( result.get(i).getAuthor() +":" + result.get(i).getName() );
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, str
        );
        listview.setAdapter(adapter);

    }

}
// 내림차순
