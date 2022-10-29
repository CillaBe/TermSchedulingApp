package com.example.wguschedulingapp.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wguschedulingapp.Entity.Assessment;
import com.example.wguschedulingapp.Entity.Course;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Course course);


    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM CourseTable ORDER BY CourseID ASC")
    List<Course> getAllCourses();
}

