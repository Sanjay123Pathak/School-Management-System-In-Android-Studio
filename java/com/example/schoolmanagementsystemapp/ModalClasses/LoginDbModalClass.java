package com.example.schoolmanagementsystemapp.ModalClasses;

import java.io.Serializable;

public class LoginDbModalClass {
    String lName ,lRegNo,lPassword;

    public LoginDbModalClass(String lName, String lRegNo, String lPassword) {
        this.lName = lName;
        this.lRegNo = lRegNo;
        this.lPassword = lPassword;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlRegNo() {
        return lRegNo;
    }

    public void setlRegNo(String lRegNo) {
        this.lRegNo = lRegNo;
    }

    public String getlPassword() {
        return lPassword;
    }

    public void setlPassword(String lPassword) {
        this.lPassword = lPassword;
    }
}
