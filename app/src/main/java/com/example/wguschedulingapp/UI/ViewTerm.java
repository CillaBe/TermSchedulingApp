package com.example.wguschedulingapp.UI;

import static com.example.wguschedulingapp.R.id.TermEnd;
import static com.example.wguschedulingapp.R.id.fade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.Entity.Term;
import com.example.wguschedulingapp.R;

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
        setContentView(R.layout.activity_view_term);
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




    }
    public void saveTerm(View view){
        Term term;
        if (termID == -1) {
            int newID = repository.getAllTerms().get(repository.getAllTerms().size() - 1).getTermID() + 1;
            term = new Term(newID, TermName.getText().toString(),TermStart.getText().toString(),TermEnd.getText().toString());
            repository.insert(term);
        } else {
            term = new Term(termID, TermName.getText().toString(),TermStart.getText().toString(),TermEnd.getText().toString());
            repository.update(term);
        }
    }
    }
