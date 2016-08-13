package com.zainzulfiqar.betbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void getDays(View view) {
        Spinner month = (Spinner) findViewById(R.id.months);
        daysOfMonths sample = new daysOfMonths();
        int days = sample.days(String.valueOf(month.getSelectedItem()));
        TextView text = (TextView) findViewById(R.id.displayDays);
        text.setText("This month has " + days + " days.");
    }
}
