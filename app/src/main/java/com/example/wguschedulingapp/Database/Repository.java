package com.example.wguschedulingapp.Database;

import android.app.Application;

import com.example.wguschedulingapp.DAO.AssessmentDAO;
import com.example.wguschedulingapp.DAO.CourseDAO;
import com.example.wguschedulingapp.DAO.TermDAO;
import com.example.wguschedulingapp.Entity.Assessment;
import com.example.wguschedulingapp.Entity.Course;
import com.example.wguschedulingapp.Entity.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private AssessmentDAO mAssessmentDAO;
    private CourseDAO mCourseDAO;
    private TermDAO mTermDAO;
    private List<Assessment> mAllAssessments;
    private List<Course> mAllCourses;
    private List<Term> mAllTerms;

    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);



    public Repository(Application application){
        DatabaseBuilder db=DatabaseBuilder.getDatabase(application);
        mTermDAO=db.termDAO();
        mCourseDAO=db.courseDAO();
        mAssessmentDAO=db.assessmentDAO();
    }

    public void insert(Term term) {

        databaseExecutor.execute(() -> {
            mTermDAO.insert(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


        public void insert(Assessment assessment) {

            databaseExecutor.execute(() -> {
                mAssessmentDAO.insert(assessment);
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    public void insert(Course course){

        databaseExecutor.execute(()->{
            mCourseDAO.insert(course);
        });
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
