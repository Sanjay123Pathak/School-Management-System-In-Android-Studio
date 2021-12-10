package com.example.schoolmanagementsystemapp.ModalClasses;

public class AnnouncementModal {
    String annType,annDate,annMessage;

    public AnnouncementModal(String annType, String annDate, String annMessage) {
        this.annType = annType;
        this.annDate = annDate;
        this.annMessage = annMessage;
    }

    public String getAnnType() {
        return annType;
    }

    public String getAnnDate() {
        return annDate;
    }

    public String getAnnMessage() {
        return annMessage;
    }
}
