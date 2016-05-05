package com.example.fighting4ever.mvpdemo.view;

/**
 * Created by Fighting4ever on 2016/5/5.
 */
public interface IView {
    void onClearText();
    void onLoginResult(Boolean result, int code);
    void onSetProgressBarVisbility(int visibility);
}
