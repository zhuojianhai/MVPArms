package me.jessyan.mvparms.demo.login;

import android.app.Activity;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;

public interface LoginContract {

    interface View extends IView{
        void loginSuccess(String result);
        Activity getActivity();
        //申请权限
        RxPermissions getRxPermissions();

    }

    interface Model extends IModel{
       Observable<String> login(String name, String pwd);
    }
}
