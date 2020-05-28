package me.jessyan.mvparms.demo.mvp.model;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import me.jessyan.mvparms.demo.login.LoginContract;
import me.jessyan.mvparms.demo.mvp.model.api.service.LoginService;
import timber.log.Timber;

@ActivityScope
public class LoginModule1 extends BaseModel implements LoginContract.Model {

    @Inject
    public LoginModule1(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<String> login(String name, String pwd) {
//        return Observable.just("success");
        return Observable.just(mRepositoryManager
                .obtainRetrofitService(LoginService.class)
                .login1(name,pwd)).flatMap(new Function<Observable<String>, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Observable<String> stringObservable) throws Exception {
                return stringObservable;
            }
        });
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        Timber.d("Release Resource");
    }
}
