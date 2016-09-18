package com.zainzulfiqar.betbook;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Display active bets.
        DatabaseHandler db = new DatabaseHandler(this);
        List<Bet> bets = db.getAllBets();
        ListView listBets = getListView();

        ArrayAdapter<Bet> adapter = new betArrayAdapter(this, 0, bets);
        listBets.setAdapter(adapter);

        Button createBet = (Button) findViewById(R.id.newBet);
        createBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(getApplicationContext(), CreateBet.class);
                startActivity(create);
            }
        });
    }

    //custom ArrayAdapter
    class betArrayAdapter extends ArrayAdapter<Bet>{

        private Context context;
        private List<Bet> bets;

        //constructor, call on creation
        public betArrayAdapter(Context context, int resource, List<Bet> objects) {
            super(context, resource, objects);
            this.context = context;
            this.bets = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the property we are displaying
            Bet bet = bets.get(position);

            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.bets_list, null);

            TextView title = (TextView) view.findViewById(R.id.listItemTitle);
            TextView description = (TextView) view.findViewById(R.id.listItemDescription);
            TextView amount = (TextView) view.findViewById(R.id.listItemAmount);

            //set price and rental attributes
            title.setText(bet.getTitle());
            description.setText(bet.getDescription());
            amount.setText("$" + String.format("%.2f", bet.getAmount()));

            return view;
        }
    }
}
