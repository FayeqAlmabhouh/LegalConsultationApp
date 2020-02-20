package com.example.legalconsultationapp.Post.model;

public class AllPostStructure {

    private String catId;
    private long date;
    private String desc;
    private String description;
    private String image;
    private long index;
    private String subCatId;
    private String title;

    public AllPostStructure
            (String catId, long date, String desc, String description, String image, long index, String subCatId, String title) {
        this.catId = catId;
        this.date = date;
        this.desc = desc;
        this.description = description;
        this.image = image;
        this.index = index;
        this.subCatId = subCatId;
        this.title = title;
    }

    public AllPostStructure() {
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(String subCatId) {
        this.subCatId = subCatId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
