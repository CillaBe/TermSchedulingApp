package com.example.wguschedulingapp.UI;

import static com.example.wguschedulingapp.R.id.TermEnd;
import static com.example.wguschedulingapp.R.id.fade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.Entity.Course;
import com.example.wguschedulingapp.Entity.Term;
import com.example.wguschedulingapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ViewTerm extends AppCompatActivity {

    EditText TermName;
    EditText TermStart;
    EditText TermEnd;

    String name;
    String start;
    String end;
    int termID;
    Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_view_term);

        final CourseAdapter adapter = new CourseAdapter(this);


        repository = new Repository(getApplication());
        TermStart = findViewById(R.id.editTermStart);
        TermEnd =findViewById(R.id.editTermEnd);
        TermName =findViewById(R.id.editTermName);

        name = getIntent().getStringExtra("name");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        termID = getIntent().getIntExtra("id",-1);

        TermName.setText(name);
        TermStart.setText(start);
        TermEnd.setText(end);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Course> CoursesByTerm = new ArrayList<>();
        for (Course course : repository.getAllCourses()){
            if (course.getTermID() == termID) {
                CoursesByTerm.add(course);
            }
            adapter.setCourse(CoursesByTerm);

        }







    }
    public void saveTerm(View view){
        Term term;
        if (termID == -1) {
            int newID = (int)Math.random();
            List<Term> allTerms = new ArrayList<>();
            for(Term t : repository.getAllTerms()){
                if(t.getTermID()== newID){
                    newID = (int)Math.random();
                }
            }
            term = new Term(newID, TermName.getText().toString(),TermStart.getText().toString(),TermEnd.getText().toString());
            repository.insert(term);
            Intent newIntent = new Intent(ViewTerm.this,TermsList.class);
            startActivity(newIntent);
        } else {
            term = new Term(termID, TermName.getText().toString(),TermStart.getText().toString(),TermEnd.getText().toString());
            repository.update(term);
            Intent newIntent = new Intent(ViewTerm.this,TermsList.class);
            startActivity(newIntent);
        }
    }
    public void goToCourseDetails(View view){
        Intent intent = new Intent(ViewTerm.this,ViewCourse.class);
        startActivity(intent);
    }

    public void DeleteTerm(View view) {
        int numberOfCourses = 0;
        for (Course course : repository.getAllCourses()){
            if (course.getTermID() == termID ){
                ++numberOfCourses;}


        }
        if(numberOfCourses == 0) {
            for (Term term : repository.getAllTerms()) {
                if (term.getTermID() == termID) {
                    repository.delete(term);
                }
                Toast.makeText(ViewTerm.this, " Confirmation: " + name + " has been successfully deleted! ", Toast.LENGTH_LONG).show();
            }
        }
            else{
            Toast.makeText(ViewTerm.this, " Error " + name + " has associated courses and cannot be deleted! ", Toast.LENGTH_LONG).show();

            }
        }

    }

