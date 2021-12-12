package com.example.schoolmanagementsystemapp.ModalClasses;

public class AssignmentModals {
    String courseName,assType,assMark,aaResult;

    public AssignmentModals(String courseName, String assType, String assMark, String aaResult) {
        this.courseName = courseName;
        this.assType = assType;
        this.assMark = assMark;
        this.aaResult = aaResult;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAssType() {
        return assType;
    }

    public void setAssType(String assType) {
        this.assType = assType;
    }

    public String getAssMark() {
        return assMark;
    }

    public void setAssMark(String assMark) {
        this.assMark = assMark;
    }

    public String getAaResult() {
        return aaResult;
    }

    public void setAaResult(String aaResult) {
        this.aaResult = aaResult;
    }
}
