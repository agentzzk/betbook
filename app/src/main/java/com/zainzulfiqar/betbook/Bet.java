package com.zainzulfiqar.betbook;

import java.util.*;

/**
 * Created by zain on 8/21/16.
 *
 * This class will be linked to the database to get all the Bets.
 *
 */
public class Bet {

    private ArrayList<String> bets = new ArrayList<String>();

    // Initialize connection to the database here.
    protected Bet() {
        bets.add("Adil can beat Malik in Soccer");
        bets.add("Zain can type faster than Malik");
        bets.add("This is just a random bet");
        bets.add("This was added in later.");
        bets.add("Sample bet 1");
        bets.add("Sample bet 2");
        bets.add("Sample bet 3");
        bets.add("Sample bet 4");
        bets.add("Sample bet 5");
        bets.add("Sample bet 6");
        bets.add("Sample bet 7");
        bets.add("Sample bet 8");
        bets.add("Sample bet 9");
    }

    protected void addBet(String name) {
        bets.add(name);
    }

    protected String[] getAllBets() {
        return bets.toArray(new String[bets.size()]);
    }
}
