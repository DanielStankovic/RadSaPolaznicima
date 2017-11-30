package com.example.daniel.radsapolaznicima.core;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.daniel.radsapolaznicima.MainActivity;
import com.example.daniel.radsapolaznicima.core.StudentContract.*;

public class StudentHelper extends SQLiteOpenHelper{


    public StudentHelper(Context context) {
        super(context, StudentContract.DATABASE_NAME, null, StudentContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentTable.SQL_CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(StudentTable.SQL_DELETE_STUDENT_TABLE);
        onCreate(db);
    }



    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues values = new ContentValues();
            values.put(StudentTable.COLUMN_NAME_NAME, student.getName());
            values.put(StudentTable.COLUMN_NAME_LASTNAME, student.getLastName());
            values.put(StudentTable.COLUMN_NAME_YEAR, student.getYear());
            values.put(StudentTable.COLUMN_NAME_POINTS, student.getPoints());

            db.insert(StudentTable.TABLE_NAME, null, values);

        }catch (Exception e){
            Log.e("Exception - Add", e.toString());
        }finally {
            db.close();
        }
    }

    public  Student[] listAll (Context context){
        Student[] students = null;


        SQLiteDatabase db = this.getReadableDatabase();

        Student student = null;
        Cursor cursor = null;
        try{

            cursor = db.rawQuery("SELECT name, lastname, year, points FROM student WHERE points > 80 ORDER BY points DESC", null);
            students = new Student[5];
            int counter = 0;


                while (cursor.moveToNext()) {

                    String name = cursor.getString(cursor.getColumnIndexOrThrow(StudentTable.COLUMN_NAME_NAME));
                    String lastName = cursor.getString(cursor.getColumnIndexOrThrow(StudentTable.COLUMN_NAME_LASTNAME));
                    String year = cursor.getString(cursor.getColumnIndexOrThrow(StudentTable.COLUMN_NAME_YEAR));
                    double points = cursor.getDouble(cursor.getColumnIndexOrThrow(StudentTable.COLUMN_NAME_POINTS));
                    student = new Student(name, lastName, year, points);
                    students[counter] = student;
                    counter++;

            }

        }catch (Exception e){
            Log.e("Exceotion - ListAll", e.toString());
        }finally {
            db.close();
            cursor.close();
        }


        return students;
    }
}
