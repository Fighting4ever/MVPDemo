package com.example.fighting4ever.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fighting4ever.mvpdemo.presenter.IPresenter;
import com.example.fighting4ever.mvpdemo.presenter.IPresenterCompl;
import com.example.fighting4ever.mvpdemo.view.IView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener{

    @Bind(R.id.user_name)
    EditText userName;
    @Bind(R.id.password) EditText password;
    @Bind(R.id.btn_login)
    Button login;
    @Bind(R.id.btn_clear) Button clear;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    private IPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new IPresenterCompl(this);
        presenter.setProgressBarVisiblity(View.INVISIBLE);
    }

    @Override
    public void onClearText() {
        userName.setText("");
        password.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        presenter.setProgressBarVisiblity(View.INVISIBLE);
        login.setEnabled(true);
        clear.setEnabled(true);
        if (result){
            textView.setText("Login Success!");
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
        }else {
            textView.setText("Login Failed !");
            Toast.makeText(this, "Login Failed !", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSetProgressBarVisbility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @OnClick({R.id.btn_clear, R.id.btn_login})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clear:
                presenter.clear();
                break;
            case R.id.btn_login:
                presenter.setProgressBarVisiblity(View.VISIBLE);
                login.setEnabled(false);
                clear.setEnabled(false);
                presenter.doLogin(userName.getText().toString(), password.getText().toString());
                break;
        }
    }
}
