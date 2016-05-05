package com.example.fighting4ever.mvpdemo.model;

/**
 * Created by Fighting4ever on 2016/5/5.
 */
public class UserModel implements IUser {
    private String userName;
    private String password;
    public UserModel(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    @Override
    public int checkUserValidity(String userName, String password) {
        if ((userName.equals(this.userName)) && password.equals(this.password)){
            return 0;
        }else {
            return -1;
        }
    }
}
