package com.masil.myjeonjutour;

public class Route {
    private String title;
    private double posx;
    //위도
    private double posy;
    //경도
    public Route() {
    }

    public Route(String title, double posx, double posy) {
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

    public double getPosx() {
        return posx;
    }

    public void setPosx(double posx) {
        this.posx = posx;
    }

    public double getPosy() {
        return posy;
    }

    public void setPosy(double posy) {
        this.posy = posy;
    }


}
