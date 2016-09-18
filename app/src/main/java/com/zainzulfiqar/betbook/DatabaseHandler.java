package com.zainzulfiqar.betbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zainzulfiqar on 2016-09-18.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "betsManager";

    // bets table name
    private static final String TABLE_NAME = "bets";

    // bets Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_DONE = "done";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BETS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_TITLE + " TEXT NOT NULL, "
                + KEY_DESCRIPTION + " TEXT, "
                + KEY_AMOUNT + " REAL, "
                + KEY_DONE + " INTEGER" + ")";
        db.execSQL(CREATE_BETS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    // Adding new Bet
    public void addBet(Bet bet) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, bet.getTitle());
        values.put(KEY_DESCRIPTION, bet.getDescription());
        values.put(KEY_AMOUNT, bet.getAmount());
        values.put(KEY_DONE, bet.getDone());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    // Getting single Bet
    public Bet getBet(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE "
                + KEY_ID + " = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null)
            cursor.moveToFirst();

        // order: id, title, description, value
        Bet bet = new Bet(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getDouble(3));
        // return Bet
        return bet;
    }

    // Getting All Bets
    public List<Bet> getAllBets() {
        List<Bet> betList = new ArrayList<Bet>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Bet bet = new Bet();
                bet.setID(Integer.parseInt(cursor.getString(0)));
                bet.setTitle(cursor.getString(1));
                bet.setDescription(cursor.getString(2));
                bet.setAmount(Double.parseDouble(cursor.getString(3)));
                bet.setDone(Integer.parseInt(cursor.getString(4)));
                // Adding bet to list
                betList.add(bet);
            } while (cursor.moveToNext());
        }

        // return bet list
        return betList;
    }

    // Getting Bets Count
    public int getBetsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single Bet
    public int updateBet(Bet bet) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, bet.getTitle());
        values.put(KEY_DESCRIPTION, bet.getDescription());
        values.put(KEY_AMOUNT, bet.getAmount());
        values.put(KEY_DONE, bet.getDone());

        // updating row
        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[] { String.valueOf(bet.getID()) });
    }

    // Deleting single Bet
    public void deleteBet(Bet bet) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?",
                new String[] { String.valueOf(bet.getID()) });
        db.close();
    }
}
