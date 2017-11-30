package com.example.daniel.radsapolaznicima;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.radsapolaznicima.core.Student;
import com.example.daniel.radsapolaznicima.core.StudentContract;
import com.example.daniel.radsapolaznicima.core.StudentHelper;

public class MainActivity extends AppCompatActivity {

    EditText nameText;
    EditText lastNameText;
    EditText yearText;
    EditText pointsText;


    Button addStudentBtn;
    Button listStudentsBtn;
    Button deleteTableBtn;

    StudentHelper studentHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (EditText)findViewById(R.id.nameText);
        lastNameText = (EditText)findViewById(R.id.lastNameText);
        yearText = (EditText)findViewById(R.id.yearText);
        pointsText = (EditText)findViewById(R.id.pointsText);

        addStudentBtn = (Button)findViewById(R.id.addStudent);
        listStudentsBtn = (Button)findViewById(R.id.listStudents);
        deleteTableBtn = (Button)findViewById(R.id.deleteTable);






    }
    public void addStudentOnClick(View v){
        String name = nameText.getText().toString();
        String lastName = lastNameText.getText().toString();
        String year = yearText.getText().toString();
        String points = pointsText.getText().toString();
        if(!isValid(name,lastName,year,points)){
            Toast.makeText(this, validationMessage, Toast.LENGTH_LONG).show();
        }else{
            studentHelper = new StudentHelper(this);
            double doubPoints = Double.parseDouble(points);
            studentHelper.addStudent(new Student(name,lastName,year,doubPoints));
            Toast.makeText(this, "Student added successfully", Toast.LENGTH_LONG).show();
        }


    }

    public void listStudentsOnClick(View v){
        Intent intent = new Intent(getApplicationContext(), ListStudentsActivity.class);
        startActivity(intent);

    }

    public void deleteTableOnClick(View v){
        studentHelper = new StudentHelper(this);
       SQLiteDatabase db = studentHelper.getReadableDatabase();
        studentHelper.onUpgrade(db, StudentContract.DATABASE_VERSION, StudentContract.DATABASE_VERSION +1);
        Toast.makeText(this, "Table " + StudentContract.StudentTable.TABLE_NAME+ " deleted", Toast.LENGTH_LONG).show();
    }

    String validationMessage;
    public boolean isValid(String name, String lastName, String year, String points){

        boolean isValid = true;

        if(name == null || name.equals("") || lastName == null || lastName.equals("") || year == null || year.equals("") || points == null || points.equals("")){
           isValid = false;
            validationMessage = "Enter the required information";
        }
        else if((Double.parseDouble(points)) >100){
            isValid = false;
            validationMessage = "Maximum number of points is 100";
        }

        return isValid;
    }

}
