package com.example.legalconsultationapp.SubCategories.model;

public class subCatogeryStructure {
    private String catId;
    private String image;
    private long index;
    private long isActive;
    private String title;
    public  static subCatogeryStructure selectedSubCatogeryStructure = null;

    public subCatogeryStructure(String catId, String image, long index, long isActive, String title) {
        this.catId = catId;
        this.image = image;
        this.index = index;
        this.isActive = isActive;
        this.title = title;
    }

    public subCatogeryStructure() {
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public long getIsActive() {
        return isActive;
    }

    public void setIsActive(long isActive) {
        this.isActive = isActive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
