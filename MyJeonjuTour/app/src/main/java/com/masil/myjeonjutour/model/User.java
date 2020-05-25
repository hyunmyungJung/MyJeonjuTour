package com.masil.myjeonjutour.model;

public class User {
    // 이메일
    private String email;
    // 이름
    private String userName;
    // 닉네임
    private String nickName;
    // 사용자 전화번호
    private String phoneNumber;

    public User(String email, String userName, String nickName, String phoneNumber){
        this.email = email;
        this.userName = userName;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}

