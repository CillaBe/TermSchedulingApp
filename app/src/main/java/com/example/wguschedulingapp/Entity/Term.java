package com.example.wguschedulingapp.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "termsTable")
public class Term {
    @PrimaryKey(autoGenerate = true)
    private int termID;

    private String TermName;
    private String TermStart;
    private String TermEnd;

    public Term(int termID, String TermName, String TermStart, String TermEnd) {
        this. TermEnd = TermEnd;
        this.termID =termID;
        this.TermName = TermName;
        this.TermStart = TermStart;
    }

    @Override
    public String toString() {
        return "Term{" +
                "termID=" + termID +
                ", TermName='" + TermName + '\'' +
                ", TermStart='" + TermStart + '\'' +
                ", TermEnd='" + TermEnd + '\'' +
                '}';
    }

    public String getTermEnd() {
        return TermEnd;
    }

    public void setTermEnd(String termEnd) {
        TermEnd = termEnd;
    }

    public String getTermStart() {
        return TermStart;
    }

    public void setTermStart(String termStart) {
        TermStart = termStart;
    }

    public String getTermName() {
        return TermName;
    }

    public void setTermName(String termName) {
        TermName = termName;
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }
}
