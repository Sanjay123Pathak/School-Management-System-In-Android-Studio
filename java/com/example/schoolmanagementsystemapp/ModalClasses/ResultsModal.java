package com.example.schoolmanagementsystemapp.ModalClasses;

public class ResultsModal {
  String TermName,T_CGPA,TCourses,TSubName,TGrades;

    public ResultsModal(String termName, String t_CGPA, String TCourses, String TSubName, String TGrades) {
        TermName = termName;
        T_CGPA = t_CGPA;
        this.TCourses = TCourses;
        this.TSubName = TSubName;
        this.TGrades = TGrades;
    }

    public String getTermName() {
        return TermName;
    }

    public String getT_CGPA() {
        return T_CGPA;
    }

    public String getTCourses() {
        return TCourses;
    }

    public String getTSubName() {
        return TSubName;
    }

    public String getTGrades() {
        return TGrades;
    }
}
