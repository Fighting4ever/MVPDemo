package com.example.fighting4ever.mvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.fighting4ever.mvpdemo.model.IUser;
import com.example.fighting4ever.mvpdemo.model.UserModel;
import com.example.fighting4ever.mvpdemo.view.IView;

/**
 * Created by Fighting4ever on 2016/5/5.
 */
public class IPresenterCompl implements IPresenter {
    private IView iView;
    private IUser user;
    Handler handler;
    public IPresenterCompl(IView iView){
        this.iView = iView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        user = new UserModel("Fighting4ever", "mvp");
    }

    @Override
    public void clear() {
        iView.onClearText();
    }

    @Override
    public void doLogin(String username, String password) {
        boolean isSuccess = true;
        final int code = user.checkUserValidity(username, password);
        if (code != 0){
            isSuccess = false;
        }
        final boolean result = isSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iView.onLoginResult(result, code);
            }
        }, 3000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iView.onSetProgressBarVisbility(visiblity);
    }
}
