package com.example.wguschedulingapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.wguschedulingapp.Database.Repository;
import com.example.wguschedulingapp.Entity.Term;
import com.example.wguschedulingapp.R;

import java.util.List;

public class TermsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView=findViewById(R.id.termrecyclerview);
        Repository repository = new Repository(getApplication());
        List<Term> terms= repository.getAllTerms();
        final TermAdapter adapter = new TermAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setTerms(terms);
    }
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_termlist, menu);
            return true;
        }
        public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

    public void goToAddTerm(View view) {
        Intent intent = new Intent(TermsList.this,AddTerm.class);
        startActivity(intent);
    }
}
