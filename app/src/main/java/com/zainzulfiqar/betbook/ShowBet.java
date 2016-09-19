package com.zainzulfiqar.betbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowBet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bet);

        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("EXTRA_BET_ID");

        DatabaseHandler db = new DatabaseHandler(this);
        Bet current = db.getBet(id);
        db.close(); // Closing database connection

        ((TextView) findViewById(R.id.showTitle)).setText(current.getTitle());
        ((TextView) findViewById(R.id.showDescription)).setText(current.getDescription());
    }
}
