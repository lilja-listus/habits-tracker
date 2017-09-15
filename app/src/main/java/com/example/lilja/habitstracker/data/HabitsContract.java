package com.example.lilja.habitstracker.data;

import android.provider.BaseColumns;

/**
 * Created by lilja on 7/21/17.
 */


public final class HabitsContract {

    private HabitsContract() {
    }

    //Inner class to set values for the database

    public static final class HabitsEntry implements BaseColumns {
        public final static String TABLE_NAME = "Habits";
        public final static String COLUMN_HABIT_NAME = "name";
        public final static String COLUMN_HABIT_TYPE = "type";
        public final static String COLUMN_HABIT_DATE = "date";
        public final static String COLUMN_HABIT_DURATION = "duration";
        public final static String COLUMN_HABIT_SATISFACTION = "satisfaction";

        // for satisfaction options
        public final static int SATISFACTION_NORMAL = 0;
        public final static int SATISFACTION_GOOD = 1;
        public final static int SATISFACTION_BAD = 2;

    }
}



