package com.example.lilja.habitstracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lilja.habitstracker.data.HabitsContract.HabitsEntry;

/**
 * Created by lilja on 7/21/17.
 */

// Database helper
public class HabitsHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "habits.db";
    private static final int DATABASE_VERSION = 1;

    //constructor of an instance
    public HabitsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // called when database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitsEntry.TABLE_NAME + " ("
                + HabitsEntry.COLUMN_HABIT_NAME + " TEXT, "
                + HabitsEntry.COLUMN_HABIT_TYPE + " TEXT, "
                + HabitsEntry.COLUMN_HABIT_DATE + " TEXT, "
                + HabitsEntry.COLUMN_HABIT_DURATION + " TEXT, "
                + HabitsEntry.COLUMN_HABIT_SATISFACTION + " INTEGER);";

        //executing database
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    // for creating an object for inserting habits
    public void insertHabit(String name, String type, String date, String duration, int satisfaction) {
        // Gets the database in write mode
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitsEntry.COLUMN_HABIT_NAME, name);
        values.put(HabitsEntry.COLUMN_HABIT_TYPE, type);
        values.put(HabitsEntry.COLUMN_HABIT_DATE, date);
        values.put(HabitsEntry.COLUMN_HABIT_DURATION, duration);
        values.put(HabitsEntry.COLUMN_HABIT_SATISFACTION, satisfaction);

        db.insert(HabitsContract.HabitsEntry.TABLE_NAME, null, values);
    }

    public Cursor query() {

        SQLiteDatabase db = getReadableDatabase();

        // defining a projection to specify which columns from the to show
        String[] projection = {
                HabitsEntry.COLUMN_HABIT_NAME,
                HabitsEntry.COLUMN_HABIT_TYPE,
                HabitsEntry.COLUMN_HABIT_DATE,
                HabitsEntry.COLUMN_HABIT_DURATION,
                HabitsEntry.COLUMN_HABIT_SATISFACTION};

        return db.query(
                HabitsEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
    }

    //to upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

