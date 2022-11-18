package com.example.wguschedulingapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.Entity.Assessment;
import com.example.wguschedulingapp.Entity.Course;
import com.example.wguschedulingapp.Entity.Term;
import com.example.wguschedulingapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterTermsList(View view) {
        Intent intent = new Intent(MainActivity.this,TermsList.class);
        startActivity(intent);

        Repository repo = new Repository(getApplication());
        Term FallTerm = new Term(1,"Fall Term","09/30/2022","12/15/2022");
        repo.insert(FallTerm);
        Term UpdatedTerm = new Term(1,"Fall 2023","09/30/2022","12/15/2022");
        repo.update(UpdatedTerm);
        Term SpringTerm23 = new Term(3,"Spring 2023","1/30/2023","05/05/2023");
        repo.insert(SpringTerm23);
        Term FallTerm23 = new Term(4,"Fall 2023","09/30/2023","12/15/2023");
        repo.insert(FallTerm23);
        Course EnglishCourse = new Course(1,1,"English 101","09/1/2022","12/15/2022","In-Progress","Bob Jones","585-900-09333","bob@aol.com","Able to be CLEPPED");
        repo.insert(EnglishCourse);
        Course HistoryCourse = new Course(2,1,"History 101","09/1/2022","12/15/2022","In-Progress","Sarah Jones","585-900-09336","sarah@aol.com","Able to be CLEPPED");
        repo.insert(HistoryCourse);



    }


}