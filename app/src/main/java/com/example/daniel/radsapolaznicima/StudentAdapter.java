package com.example.daniel.radsapolaznicima;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daniel.radsapolaznicima.core.Student;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int resourceId;
    private Student [] students;


    public StudentAdapter( Context context, int resource, Student[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceId = resource;
        this.students = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        StudentHolder studentHolder;

        if(row == null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            row = layoutInflater.inflate(resourceId, parent, false);

            studentHolder = new StudentHolder();
            studentHolder.nameText = (TextView)row.findViewById(R.id.textViewName);
            studentHolder.lastnameText = (TextView)row.findViewById(R.id.textViewLastname);
            studentHolder.yearText = (TextView)row.findViewById(R.id.textViewYear);
            studentHolder.pointsText = (TextView)row.findViewById(R.id.textViewPoints);
            row.setTag(studentHolder);
        }
        else {
            studentHolder = (StudentHolder) row.getTag();
        }

      Student student = students[position];

        if(!(student == null)) {
      studentHolder.nameText.setText(student.getName());
      studentHolder.lastnameText.setText(student.getLastName());
      studentHolder.yearText.setText(student.getYear());
      String points = String.valueOf(student.getPoints());
      studentHolder.pointsText.setText(points);
  }

        return row;
    }

    private static class StudentHolder{
        TextView nameText;
        TextView lastnameText;
        TextView yearText;
        TextView pointsText;

    }
}
