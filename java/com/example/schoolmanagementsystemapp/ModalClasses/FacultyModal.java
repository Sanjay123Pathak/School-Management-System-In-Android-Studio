package com.example.schoolmanagementsystemapp.ModalClasses;

public class FacultyModal {
    int fImage;
    String fName,fDepartment;

    public FacultyModal(int fImage, String fDepartment,String fName) {
        this.fImage = fImage;
        this.fName = fName;
        this.fDepartment = fDepartment;
    }

    public int getFImage() {
        return fImage;
    }

    public void setFImage(int fImage) {
        this.fImage = fImage;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFDepartment() {
        return fDepartment;
    }

    public void setFDepartment(String fDepartment) {
        this.fDepartment = fDepartment;
    }
}
