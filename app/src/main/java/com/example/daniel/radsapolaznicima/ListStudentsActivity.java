package com.example.daniel.radsapolaznicima;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class ListStudentsActivity extends AppCompatActivity {
    FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        fragmentContainer = (FrameLayout)findViewById(R.id.fragment_container);

        if(fragmentContainer != null){
            if(savedInstanceState == null){
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment listStudents = new ListStudentsFragment();

                ft.add(fragmentContainer.getId(), listStudents);
                ft.commit();
            }
        }
    }
}
