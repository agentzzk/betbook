package com.zainzulfiqar.betbook;

import java.util.*;

/**
 * Created by zain on 8/21/16.
 *
 * This class will be linked to the database to get all the Bets.
 *
 */
public class Bet {

    private int id;
    private String title;
    private String description;
    private Double amount;
    private int done;

    protected Bet() {

    }

    protected Bet (int id, String title, String description, Double amount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.done = 0;
    }

    protected Bet (String title, String description, Double amount) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.done = 0;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
