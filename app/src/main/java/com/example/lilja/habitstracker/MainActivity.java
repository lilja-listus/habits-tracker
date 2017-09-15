package com.example.lilja.habitstracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lilja.habitstracker.data.HabitsContract.HabitsEntry;
import com.example.lilja.habitstracker.data.HabitsHelper;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Database helper that gives access to the database
    private HabitsHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new HabitsHelper(this);

        //inserting real habits into the db
        helper.insertHabit("Book", "Reading", "12.07", "30 mins", HabitsEntry.SATISFACTION_GOOD);
        helper.insertHabit("Running", "Sport", "13.07", "40 mins", HabitsEntry.SATISFACTION_NORMAL);
        helper.insertHabit("Watching TV", "Leisure", "12.07", "1 hour", HabitsEntry.SATISFACTION_BAD);
        helper.insertHabit("Studying", "Education", "13.07", "30 mins", HabitsEntry.SATISFACTION_GOOD);

        Cursor cursor = helper.query();

        // the table is printed out in the log
        try {
            while (cursor.moveToNext()) {
                Log.i(LOG_TAG, "Habit: " + cursor.getString(0) + " - "
                        + cursor.getString(1) + " - " +
                        cursor.getString(2) + " - " +
                        cursor.getString(3) + " - " +
                        cursor.getInt(4));
            }
        } finally {
            cursor.close();
        }
    }
}
