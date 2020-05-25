package com.masil.myjeonjutour.model;


import com.masil.myjeonjutour.Route;

import java.util.ArrayList;

public class MyRoute {
    private String routename;
    private ArrayList<Route> route;

    public MyRoute(String routename, ArrayList<Route> route) {
        this.routename = routename;
        this.setRoute(route);
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename;
    }

    public ArrayList<Route> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<Route> route) {
        this.route = route;
    }
}
