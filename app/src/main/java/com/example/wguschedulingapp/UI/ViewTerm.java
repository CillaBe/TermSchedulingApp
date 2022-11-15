package com.example.wguschedulingapp.UI;

import static com.example.wguschedulingapp.R.id.TermEnd;
import static com.example.wguschedulingapp.R.id.fade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.R;

public class ViewTerm extends AppCompatActivity {

    EditText TermName;
    EditText TermStart;
    EditText TermEnd;

    String name;
    String start;
    String end;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_term);

        TermStart = findViewById(R.id.editTermStart);
        TermEnd =findViewById(R.id.editTermEnd);
        TermName =findViewById(R.id.editTermName);

        name = getIntent().getStringExtra("name");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");

        TermName.setText(name);
        TermStart.setText(start);
        TermEnd.setText(end);




    }
}