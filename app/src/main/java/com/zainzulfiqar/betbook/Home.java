package com.zainzulfiqar.betbook;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listBets = getListView();
        String[] test = {"hello", "testing", "123"};
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, test);
        listBets.setAdapter(listAdapter);
    }
}
