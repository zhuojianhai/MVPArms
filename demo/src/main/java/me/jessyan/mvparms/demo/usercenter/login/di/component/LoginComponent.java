package me.jessyan.mvparms.demo.usercenter.login.di.component;

import dagger.BindsInstance;
import dagger.Component;
import com.jess.arms.di.component.AppComponent;

import me.jessyan.mvparms.demo.usercenter.login.di.module.LoginModule;
import me.jessyan.mvparms.demo.usercenter.login.mvp.contract.LoginContract;

import com.jess.arms.di.scope.ActivityScope;
import me.jessyan.mvparms.demo.usercenter.login.mvp.ui.activity.LoginActivity;   


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
@ActivityScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
    @Component.Builder
    interface Builder {
        @BindsInstance
        LoginComponent.Builder view(LoginContract.View view);
        LoginComponent.Builder appComponent(AppComponent appComponent);
        LoginComponent build();
    }
}