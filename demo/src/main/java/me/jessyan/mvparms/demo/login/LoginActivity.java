package me.jessyan.mvparms.demo.login;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View , View.OnClickListener{
    @Inject
    RxPermissions mRxPermissions;

    @BindView(R.id.bt_login)
    Button login;
    @BindView(R.id.tv_result)
    TextView textView;


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {


        DaggerLoginComponent
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.login("","");
        login.setOnClickListener(this);

    }


    @Override
    public void loginSuccess(String result) {

        textView.setText(result);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
    }

    @Override
    public void showMessage(@NonNull String message) {


    }

    @Override
    public void onClick(View v) {
        if (v == login){
            mPresenter.login("zhuojianhai","123456");
        }
    }
}
