package com.example.wguschedulingapp.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "AssessmentTable")
public class Assessment {


    @PrimaryKey(autoGenerate = true)

    private int AssessmentID;

    private String PerformanceAssessment;
    private String ObjectiveAssessment;
    private String AssessmentTitle;
    private String AssessmentEnd;
    private String AssessmentStart;

    public String getAssessmentStart() {
        return AssessmentStart;
    }

    public String getAssessmentEnd() {
        return AssessmentEnd;
    }

    private int CourseID;

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "AssessmentID=" + AssessmentID +
                ", PerformanceAssessment='" + PerformanceAssessment + '\'' +
                ", ObjectiveAssessment='" + ObjectiveAssessment + '\'' +
                ", AssessmentTitle='" + AssessmentTitle + '\'' +
                ", AssessmentEnd=" + AssessmentEnd +
                ", AssessmentStart=" + AssessmentStart +
                ", CourseID=" + CourseID +
                '}';
    }

    public void setAssessmentStart(String assessmentStart) {
        AssessmentStart = assessmentStart;
    }

    public void setAssessmentEnd(String assessmentEnd) {
        AssessmentEnd = assessmentEnd;
    }

    public Assessment(int AssessmentID, int CourseID, String PerformanceAssessment, String AssessmentTitle, String AssessmentEnd, String AssessmentStart) {
        this.AssessmentID = AssessmentID;
        this.CourseID = CourseID;
        this.PerformanceAssessment = PerformanceAssessment;
        this.AssessmentTitle = AssessmentTitle;
        this.AssessmentEnd = AssessmentEnd;
        this.AssessmentStart = AssessmentStart;
    }








    public String getAssessmentTitle() {
        return AssessmentTitle;
    }

    public void setAssessmentTitle(String assessmentTitle) {
        AssessmentTitle = assessmentTitle;
    }

    public String getObjectiveAssessment() {
        return ObjectiveAssessment;
    }

    public void setObjectiveAssessment(String objectiveAssessment) {
        ObjectiveAssessment = objectiveAssessment;
    }

    public String getPerformanceAssessment() {
        return PerformanceAssessment;
    }

    public void setPerformanceAssessment(String performanceAssessment) {
        PerformanceAssessment = performanceAssessment;
    }

    public int getAssessmentID() {
        return AssessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        AssessmentID = assessmentID;
    }
}
