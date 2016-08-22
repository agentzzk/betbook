package com.zainzulfiqar.betbook;

import android.app.Activity;
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
        setContentView(R.layout.activity_home);

        // Display active bets.
        ListView listBets = getListView();
        Bet list = new Bet();
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list.getAllBets());
        listBets.setAdapter(listAdapter);
    }

    protected void createBet(View view) {
        Intent create = new Intent(this, CreateBet.class);
        startActivity(create);
    }
}
