package me.jessyan.mvparms.demo.usercenter.login.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.ui.activity.UserActivity;
import me.jessyan.mvparms.demo.usercenter.login.di.component.DaggerLoginComponent;
import me.jessyan.mvparms.demo.usercenter.login.di.module.entity.WanUser;
import me.jessyan.mvparms.demo.usercenter.login.mvp.contract.LoginContract;
import me.jessyan.mvparms.demo.usercenter.login.mvp.presenter.LoginPresenter;
import timber.log.Timber;


import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 05/27/2020 18:30
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View, View.OnClickListener {
    @BindView(R.id.bt_login)
    Button button;

    @BindView(R.id.et_login_name)
    EditText loginName;
    @BindView(R.id.et_login_pwd)
    EditText loginPwd;



    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }


    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        button.setOnClickListener(this);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v==button){
            String name = loginName.getText().toString();
            String pwd = loginPwd.getText().toString();
          mPresenter.login(name,pwd);
        }
    }

    @SuppressLint("TimberArgCount")
    @Override
    public void loginSuccess(WanUser result) {
        Timber.i("Login",result);
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFail(String failStr) {
        ArmsUtils.snackbarText(failStr);
    }
}
