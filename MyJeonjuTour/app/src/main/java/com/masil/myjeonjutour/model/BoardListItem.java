package com.masil.myjeonjutour.model;

public class BoardListItem {
    public int Num;
    public String Title;
    public String Detail;
    public long Date;
    public String Writer;

    public BoardListItem() {

    }

    public BoardListItem(String title, String name, long date, String detail){
        Num = Num;
        Title=title;
        Date=date;
        Writer=name;
        Detail=detail;

    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public long getDate() {
        return Date;
    }

    public void setDate(long date) {
        Date = date;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }
}

