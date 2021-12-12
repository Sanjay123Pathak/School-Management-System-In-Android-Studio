package com.example.schoolmanagementsystemapp.ModalClasses;

public class FeeModals {
    String feeBal,feeDate,feeAmnt,feeYr,feeSem,feeDrCr;

    public FeeModals(String feeBal, String feeDate, String feeAmnt, String feeYr, String feeSem, String feeDrCr) {
        this.feeBal = feeBal;
        this.feeDate = feeDate;
        this.feeAmnt = feeAmnt;
        this.feeYr = feeYr;
        this.feeSem = feeSem;
        this.feeDrCr = feeDrCr;
    }

    public String getFeeBal() {
        return feeBal;
    }

    public void setFeeBal(String feeBal) {
        this.feeBal = feeBal;
    }

    public String getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(String feeDate) {
        this.feeDate = feeDate;
    }

    public String getFeeAmnt() {
        return feeAmnt;
    }

    public void setFeeAmnt(String feeAmnt) {
        this.feeAmnt = feeAmnt;
    }

    public String getFeeYr() {
        return feeYr;
    }

    public void setFeeYr(String feeYr) {
        this.feeYr = feeYr;
    }

    public String getFeeSem() {
        return feeSem;
    }

    public void setFeeSem(String feeSem) {
        this.feeSem = feeSem;
    }

    public String getFeeDrCr() {
        return feeDrCr;
    }

    public void setFeeDrCr(String feeDrCr) {
        this.feeDrCr = feeDrCr;
    }
}
