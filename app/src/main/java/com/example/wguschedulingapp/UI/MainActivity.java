package com.example.wguschedulingapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.Entity.Assessment;
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

    }


}