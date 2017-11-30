package com.example.daniel.radsapolaznicima;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.daniel.radsapolaznicima.core.Student;
import com.example.daniel.radsapolaznicima.core.StudentHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListStudentsFragment extends Fragment {
    ListView listView;
    TextView  textView;



    public ListStudentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_students, container, false);

        listView = (ListView)view.findViewById(R.id.studentsListView);
//          textView = (TextView)view.findViewById(R.id.emptyTextView);
//        listView.setEmptyView(textView);

        listAllStudents(listView);



        return view;
    }

    private void listAllStudents(ListView listView){
        StudentHelper studentHelper = new StudentHelper(getContext());
        Student[] students = studentHelper.listAll(getActivity());
            final StudentAdapter studentAdapter = new StudentAdapter(getActivity(), R.layout.one_student, students);
            listView.setAdapter(studentAdapter);
        listView.setEmptyView(textView);

    }

}
