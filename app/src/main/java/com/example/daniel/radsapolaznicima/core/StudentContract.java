package com.example.daniel.radsapolaznicima.core;


import android.provider.BaseColumns;

public class StudentContract {

    private StudentContract(){

    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Academy";

    public static abstract class StudentTable implements BaseColumns {

        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_LASTNAME = "lastname";
        public static final String COLUMN_NAME_YEAR = "year";
        public static final String COLUMN_NAME_POINTS = "points";

        public static final String SQL_CREATE_STUDENT_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_NAME + " TEXT," +
                        COLUMN_NAME_LASTNAME + " TEXT," +
                        COLUMN_NAME_YEAR + " TEXT," +
                        COLUMN_NAME_POINTS + " INTEGER)";
        public static final String SQL_DELETE_STUDENT_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
