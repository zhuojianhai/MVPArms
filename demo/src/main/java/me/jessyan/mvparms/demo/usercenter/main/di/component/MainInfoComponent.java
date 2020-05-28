package me.jessyan.mvparms.demo.usercenter.main.di.component;

import dagger.BindsInstance;
import dagger.Component;
import com.jess.arms.di.component.AppComponent;

import me.jessyan.mvparms.demo.usercenter.main.di.module.MainInfoModule;
import me.jessyan.mvparms.demo.usercenter.main.mvp.contract.MainInfoContract;

import com.jess.arms.di.scope.ActivityScope;
import me.jessyan.mvparms.demo.usercenter.main.mvp.ui.activity.MainInfoActivity;   


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 05/28/2020 15:56
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = MainInfoModule.class, dependencies = AppComponent.class)
public interface MainInfoComponent {
    void inject(MainInfoActivity activity);
    @Component.Builder
    interface Builder {
        @BindsInstance
        MainInfoComponent.Builder view(MainInfoContract.View view);
        MainInfoComponent.Builder appComponent(AppComponent appComponent);
        MainInfoComponent build();
    }
}