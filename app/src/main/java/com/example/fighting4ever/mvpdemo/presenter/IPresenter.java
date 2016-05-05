package com.example.fighting4ever.mvpdemo.presenter;

/**
 * Created by Fighting4ever on 2016/5/5.
 */
public interface IPresenter {
    void clear();
    void doLogin(String username, String password);
    void setProgressBarVisiblity(int visiblity);
}
