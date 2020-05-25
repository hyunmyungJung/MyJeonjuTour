package com.masil.myjeonjutour.model;

public class ParkData {
    private String title;
    private String posx;
    private String posy;

    public ParkData() {
    }

    public ParkData(String title, String posx, String posy) {
        this.title = title;
        this.posx = posx;
        this.posy = posy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosx() {
        return posx;
    }

    public void setPosx(String posx) {
        this.posx = posx;
    }

    public String getPosy() {
        return posy;
    }

    public void setPosy(String posy) {
        this.posy = posy;
    }
}
