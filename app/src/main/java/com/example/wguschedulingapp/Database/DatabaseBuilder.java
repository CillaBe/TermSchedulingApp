package com.example.wguschedulingapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.wguschedulingapp.DAO.AssessmentDAO;
import com.example.wguschedulingapp.DAO.CourseDAO;
import com.example.wguschedulingapp.DAO.TermDAO;
import com.example.wguschedulingapp.Entity.Assessment;
import com.example.wguschedulingapp.Entity.Course;
import com.example.wguschedulingapp.Entity.Term;

@Database(entities={Assessment.class, Term.class,Course.class}, version=4, exportSchema = false)
public abstract class DatabaseBuilder extends RoomDatabase {
    public abstract AssessmentDAO assessmentDAO();
    public abstract CourseDAO courseDAO();
    public abstract TermDAO termDAO();

    private static volatile DatabaseBuilder INSTANCE;

    static DatabaseBuilder getDatabase(final Context context) {
        if(INSTANCE==null){
            synchronized (DatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseBuilder.class, "myTermDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

