package com.example.wguschedulingapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.R;

public class ViewAssessment extends AppCompatActivity {

    EditText editAssessmentName;
    EditText editAssessmentType;
    EditText editAssessmentStart;
    EditText editAssessmentEnd;
    EditText editAssessmentCourseID;
    EditText editAssessmentID;

    int AssessmentID;
    int CourseID;
    String AssessmentName;
    String AssessmentType;
    String AssessmentStart;
    String AssessmentEnd;

    Repository repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_view_assessment);
        repo = new Repository(getApplication());

        editAssessmentType = findViewById(R.id.editAssessmentType);
        editAssessmentName = findViewById(R.id.editAssessmentName);
        editAssessmentStart = findViewById(R.id.editAssessmentStart);
        editAssessmentEnd = findViewById(R.id.editAssessmentEnd);
        editAssessmentID = findViewById(R.id.editAssessmentIdInAssessment);
        editAssessmentCourseID = findViewById(R.id.editCourseIdInAssessment);

        AssessmentName = getIntent().getStringExtra("AssessmentTitle");
        AssessmentType = getIntent().getStringExtra("AssessmentType");
        AssessmentStart = getIntent().getStringExtra("AssessmentStart");
        AssessmentEnd = getIntent().getStringExtra("AssessmentEnd");
        AssessmentID = getIntent().getIntExtra("AssessmentID",-1);
        CourseID = getIntent().getIntExtra("CourseID",-1);



        editAssessmentName.setText(AssessmentName);
        editAssessmentType.setText(AssessmentType);
        editAssessmentStart.setText(AssessmentStart);
        editAssessmentEnd.setText(AssessmentEnd);
        editAssessmentID.setText(String.valueOf(AssessmentID));
        editAssessmentCourseID.setText(String.valueOf(CourseID));
    }


}