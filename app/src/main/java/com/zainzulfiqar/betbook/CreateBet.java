package com.zainzulfiqar.betbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CreateBet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bet);
    }

    protected void saveBet(View view) {

        // Code to retrieve data and save it in database/online database

        finishActivity(1);
    }
}
