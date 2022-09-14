package com.example.finbit_android_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import Models.Employee;

public class MyDb extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Employees.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "employee_table";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "employee_name";
    private static final String COLUMN_SALARY = "employee_salary";
    private static final String COLUMN_AGE = "employee_age";

    public MyDb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_SALARY + " INTEGER, " +
                COLUMN_AGE + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
