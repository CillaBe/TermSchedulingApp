package com.example.wguschedulingapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.Entity.Assessment;
import com.example.wguschedulingapp.Entity.Course;
import com.example.wguschedulingapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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



    String DateFormatter = "MM/dd/yy";
    SimpleDateFormat SimpleFormat = new SimpleDateFormat(DateFormatter, Locale.US);


    final Calendar myCalenderBegin = Calendar.getInstance();
    final Calendar myCalenderEnd = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener startDate;
    DatePickerDialog.OnDateSetListener endDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_view_assessment);
        repo = new Repository(getApplication());

        String DateFormatter = "MM/dd/yy";
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat(DateFormatter, Locale.US);

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

        editAssessmentStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date;
                String dateinformation = editAssessmentStart.getText().toString();
                if (dateinformation.equals("")) dateinformation = "11/11/2011";
                try {
                    myCalenderBegin.setTime(SimpleFormat.parse(dateinformation));
                } catch (ParseException e) {
                    e.printStackTrace();

                }

                new DatePickerDialog(ViewAssessment.this, startDate, myCalenderBegin.get(Calendar.YEAR), myCalenderBegin.get(Calendar.MONTH), myCalenderBegin.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

        startDate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalenderBegin.set(Calendar.YEAR, year);
                myCalenderBegin.set(Calendar.MONTH, month);
                myCalenderBegin.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();

            }

        };
        editAssessmentEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date;
                String dateinformation = editAssessmentEnd.getText().toString();
                if (dateinformation.equals("")) dateinformation = "11/11/2011";
                try {
                    myCalenderEnd.setTime(SimpleFormat.parse(dateinformation));
                } catch (ParseException e) {
                    e.printStackTrace();

                }

                new DatePickerDialog(ViewAssessment.this, endDate, myCalenderEnd.get(Calendar.YEAR), myCalenderEnd.get(Calendar.MONTH), myCalenderEnd.get(Calendar.DAY_OF_MONTH)).show();


            }
        });


        endDate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalenderEnd.set(Calendar.YEAR, year);
                myCalenderEnd.set(Calendar.MONTH, month);
                myCalenderEnd.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelEnd();

            }

        };
    }
    private void updateLabelStart() {
        editAssessmentStart.setText(SimpleFormat.format(myCalenderBegin.getTime()));
    }
    private void updateLabelEnd() {
        editAssessmentEnd.setText(SimpleFormat.format(myCalenderEnd.getTime()));
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