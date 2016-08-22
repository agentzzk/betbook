package com.zainzulfiqar.betbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CreateBet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bet);

        // Display appropriate fields for a new bet.
    }

    protected void saveBet(View view) {
        // Code to retrieve data and save it in database/online database
        Intent home = new Intent(this, Home.class);
        Toast.makeText(this, "Bet created.", Toast.LENGTH_LONG).show();
        startActivity(home);
    }
}
