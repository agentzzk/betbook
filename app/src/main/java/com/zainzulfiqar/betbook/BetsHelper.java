package com.zainzulfiqar.betbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zain on 8/21/16.
 */
public class BetsHelper extends SQLiteOpenHelper {
    public BetsHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int currentVer, int newVer) {

    }
}
