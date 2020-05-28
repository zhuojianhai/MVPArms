package me.jessyan.mvparms.demo.login;
import android.support.v4.app.FragmentActivity;

import com.jess.arms.di.scope.ActivityScope;
import com.tbruyelle.rxpermissions2.RxPermissions;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.model.LoginModule1;


@Module
public abstract class LoginModule {

    @Binds
    abstract  LoginContract.Model bindLoginModule(LoginModule1 loginModule);

    @ActivityScope
    @Provides
    static RxPermissions provideRxPermissions(LoginContract.View view) {
        return new RxPermissions((FragmentActivity) view.getActivity());
    }

}
