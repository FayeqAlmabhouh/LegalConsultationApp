package com.example.legalconsultationapp.CatogeryModel;

public class CatogeryStructure {

    private Long IsActive;
    private Long PostCount;
    private boolean haveSub;
    private String image;
    private long index;
    private String key;
    private String title;

    public static CatogeryStructure SelectedCatogery = null;

    public CatogeryStructure() {
    }



    public CatogeryStructure(Long isActive, Long postCount, boolean haveSub, String image, long index, String key, String title) {
        IsActive = isActive;
        PostCount = postCount;
        this.haveSub = haveSub;
        this.image = image;
        this.index = index;
        this.key = key;
        this.title = title;
    }

    public Long getIsActive() {
        return IsActive;
    }

    public void setIsActive(Long isActive) {
        IsActive = isActive;
    }

    public Long getPostCount() {
        return PostCount;
    }

    public void setPostCount(Long postCount) {
        PostCount = postCount;
    }

    public boolean isHaveSub() {
        return haveSub;
    }

    public void setHaveSub(boolean haveSub) {
        this.haveSub = haveSub;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public CatogeryStructure getSelectedCatogery() {
        return SelectedCatogery;
    }

    public void setSelectedCatogery(CatogeryStructure selectedCatogery) {
        SelectedCatogery = selectedCatogery;
    }
}
