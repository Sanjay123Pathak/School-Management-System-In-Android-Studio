package com.example.schoolmanagementsystemapp.ModalClasses;

public class MyRecyclerViewModal {
    String nameItem;
    int images;

    public MyRecyclerViewModal(String nameItem, int images) {
        this.nameItem = nameItem;
        this.images = images;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }


}
