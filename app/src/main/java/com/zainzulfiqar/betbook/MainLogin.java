package com.zainzulfiqar.betbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void generateMadlib(View view) {
        String words[] = {((EditText) findViewById(R.id.editText)).getText().toString(),
                        ((EditText) findViewById(R.id.editText2)).getText().toString(),
                        ((EditText) findViewById(R.id.editText3)).getText().toString(),
                        ((EditText) findViewById(R.id.editText4)).getText().toString(),
                        ((EditText) findViewById(R.id.editText5)).getText().toString(),
                        ((EditText) findViewById(R.id.editText6)).getText().toString()};
        TextView madlib = (TextView) findViewById(R.id.madlibHolder);
        String text = new madlibs().getMadlib(words);
        madlib.setText(text);
    }
}
