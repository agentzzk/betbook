package com.zainzulfiqar.betbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateBet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bet);

        // Display appropriate fields for a new bet.
        final EditText titleText = (EditText) findViewById(R.id.title);
        final EditText descriptionText = (EditText) findViewById(R.id.description);
        final EditText amountText = (EditText) findViewById(R.id.amount);
        final DatabaseHandler db = new DatabaseHandler(this);

        Button save = (Button) findViewById(R.id.saveBet);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleText.getText().toString();
                String description = descriptionText.getText().toString();
                Double amount = Double.parseDouble(amountText.getText().toString());

                db.addBet(new Bet(title, description, amount));
                db.close(); // Closing database connection

                Intent home = new Intent(getApplicationContext(), Home.class);
                startActivity(home);
                Toast.makeText(getApplicationContext(), "\"" + title + "\" was added.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
