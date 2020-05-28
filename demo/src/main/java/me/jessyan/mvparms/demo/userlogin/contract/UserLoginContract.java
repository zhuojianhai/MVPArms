package me.jessyan.mvparms.demo.userlogin.contract;

import android.app.Activity;

import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import io.reactivex.Observable;
import me.jessyan.mvparms.demo.mvp.model.entity.User;

public interface UserLoginContract {

    interface LoginView extends IView {
        void loginSuccess(String result);
        Activity getActivity();
        //申请权限
        RxPermissions getRxPermissions();

    }

    interface LoginModel extends IModel {
        Observable<List<User>> login(String name, String pwd);
    }
}
