package com.example.wguschedulingapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.Entity.Assessment;
import com.example.wguschedulingapp.Entity.Course;
import com.example.wguschedulingapp.Entity.Term;
import com.example.wguschedulingapp.R;

import java.util.ArrayList;
import java.util.List;

public class ViewCourse extends AppCompatActivity {
    EditText EditCourseID;
    EditText EditTermID;
    EditText EditCourseTitle;
    EditText EditCourseStart;
    EditText EditCourseEnd;
    EditText EditCourseStatus;
    EditText EditInstructorName;
    EditText EditInstructorEmail;
    EditText EditInstructorPhone;
    EditText EditNotes;

    int CourseId;
    int TermId;
    String CourseTitle;
    String CourseStart;
    String CourseEnd;
    String CourseStatus;
    String InstructorName;
    String InstructorEmail;
    String InstructorPhone;
    String Notes;

    Repository repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final AssessmentAdapter adapter = new AssessmentAdapter(this);
        repo = new Repository(getApplication());
        EditCourseID = findViewById(R.id.editCourseID);
        EditTermID = findViewById(R.id.editTermID);
        EditCourseTitle = findViewById(R.id.editCourseName);
        EditCourseStart = findViewById(R.id.editCourseStart);
        EditCourseEnd = findViewById(R.id.editCourseEnd);
        EditCourseStatus = findViewById(R.id.editCourseStatus);
        EditInstructorName = findViewById(R.id.editInstructorName);
        EditInstructorPhone = findViewById(R.id.editInstructorPhone);
        EditNotes = findViewById(R.id.editOptionalNotes);
        EditInstructorEmail = findViewById(R.id.editInstructorEmail);

        CourseId = getIntent().getIntExtra("CourseId",-1);
        TermId = getIntent().getIntExtra("TermID",-1);
        CourseTitle = getIntent().getStringExtra("CourseTitle");
        CourseStart = getIntent().getStringExtra("CourseStart");
        CourseEnd = getIntent().getStringExtra("CourseEnd");
        CourseStatus = getIntent().getStringExtra("CourseStatus");
        InstructorName = getIntent().getStringExtra("CourseInstructorName");
        InstructorEmail = getIntent().getStringExtra("InstructorEmail");
        InstructorPhone = getIntent().getStringExtra("InstructorPhone");
        Notes = getIntent().getStringExtra("CourseNote");

        EditCourseID.setText(String.valueOf(CourseId));
        EditTermID.setText(String.valueOf(TermId));
        EditCourseTitle.setText(CourseTitle);
        EditCourseStart.setText(CourseStart);
        EditCourseEnd.setText(CourseEnd);
        EditCourseStatus.setText(CourseStatus);
        EditInstructorName.setText(InstructorName);
        EditInstructorPhone.setText(InstructorPhone);
        EditInstructorEmail.setText(InstructorEmail);
        EditNotes.setText(Notes);

        RecyclerView recyclerView = findViewById(R.id.AssessmentRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Assessment> AssessmentsByTerm = new ArrayList<>();
        for (Assessment assessment : repo.getAllAssessments()){
            if (assessment.getCourseID() == CourseId) {
                AssessmentsByTerm.add(assessment);
            }
            adapter.setAssessments(AssessmentsByTerm);

        }
    }
    public void saveCourse(View view){
        Course course;
        if (CourseId == -1) {
            int newID = (int)Math.random();

            for(Course c : repo.getAllCourses()){
                if(c.getCourseID()== newID){
                    newID = (int)Math.random();
                }
            }
            course = new Course(newID, Integer.parseInt(EditTermID.getText().toString()),EditCourseTitle.getText().toString(),EditCourseStart.getText().toString(),EditCourseEnd.getText().toString(),EditCourseStatus.getText().toString(),EditInstructorName.getText().toString(),EditInstructorPhone.getText().toString(),EditInstructorEmail.getText().toString(),EditNotes.getText().toString());
            repo.insert(course);
            Intent newIntent = new Intent(ViewCourse.this,TermsList.class);
            startActivity(newIntent);
        } else {
            course = new Course(CourseId,  Integer.parseInt(EditTermID.getText().toString()),EditCourseTitle.getText().toString(),EditCourseStart.getText().toString(),EditCourseEnd.getText().toString(),EditCourseStatus.getText().toString(),EditInstructorName.getText().toString(),EditInstructorPhone.getText().toString(),EditInstructorEmail.getText().toString(),EditNotes.getText().toString());
            repo.update(course);
            Intent newIntent = new Intent(ViewCourse.this,TermsList.class);
            startActivity(newIntent);
        }
    }
}
