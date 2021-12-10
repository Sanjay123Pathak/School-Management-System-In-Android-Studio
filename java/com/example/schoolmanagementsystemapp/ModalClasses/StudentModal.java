package com.example.schoolmanagementsystemapp.ModalClasses;

public class StudentModal {
    int SImage,SReg_no;
    String SName,Section;

    public StudentModal(int SImage,String SName, int SReg_no, String section) {
        this.SImage = SImage;
        this.SName=SName;
        this.SReg_no = SReg_no;
        this.Section = section;

    }

    public int getSImage() {
        return SImage;
    }

    public void setSImage(int SImage) {
        this.SImage = SImage;
    }
    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }
    public int getSReg_no() {
        return SReg_no;
    }

    public void setSReg_no(int SReg_no) {
        this.SReg_no = SReg_no;
    }



    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }
}
