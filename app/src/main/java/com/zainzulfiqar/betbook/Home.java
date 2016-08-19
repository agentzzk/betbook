package com.zainzulfiqar.betbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AdapterView.OnItemClickListener betsListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Toast.makeText(getApplicationContext(), "first", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "other", Toast.LENGTH_SHORT).show();
                }
            }
        };
        ListView bets = (ListView) findViewById(R.id.listBets);
        bets.setOnItemClickListener(betsListener);
    }

    protected void createBet(View view) {
        Intent createBet = new Intent(this, CreateBet.class);
        startActivityForResult(createBet, 1);
    }
}
