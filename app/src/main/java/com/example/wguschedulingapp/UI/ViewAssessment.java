package com.example.wguschedulingapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.Entity.Assessment;
import com.example.wguschedulingapp.Entity.Course;
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
        editAssessmentCourseID.setText(String.valueOf(CourseID));
    }
    public void saveAssessment(View view){
        Assessment assessment;

        if (AssessmentID == -1) {
            int id = (int)Math.random();

            for(Assessment a : repo.getAllAssessments()){
                if(a.getAssessmentID()== id){
                    id= (int)Math.random();
                }
            }
            assessment= new Assessment(id,Integer.parseInt(editAssessmentCourseID.getText().toString()),editAssessmentType.getText().toString(),editAssessmentName.getText().toString(),editAssessmentStart.getText().toString(),editAssessmentEnd.getText().toString());
            repo.insert(assessment);
            Intent newIntent = new Intent(ViewAssessment.this,TermsList.class);
            startActivity(newIntent);
        }
         else {
            assessment = new Assessment(AssessmentID,Integer.parseInt(editAssessmentCourseID.getText().toString()),editAssessmentType.getText().toString(),editAssessmentName.getText().toString(),editAssessmentStart.getText().toString(),editAssessmentEnd.getText().toString());
            repo.update(assessment);
            Intent newIntent = new Intent(ViewAssessment.this,TermsList.class);
            startActivity(newIntent);
        }
    }
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_assessmentlist,menu);
        return true;
    }


}