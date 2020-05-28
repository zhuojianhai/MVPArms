package me.jessyan.mvparms.demo.usercenter.login.mvp.presenter;

import android.app.Application;

import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.utils.RxLifecycleUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.mvparms.demo.mvp.model.entity.BaseResponse;
import me.jessyan.mvparms.demo.usercenter.login.di.module.entity.WanUser;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import javax.inject.Inject;

import me.jessyan.mvparms.demo.usercenter.login.mvp.contract.LoginContract;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;
import timber.log.Timber;


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
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public LoginPresenter (LoginContract.Model model, LoginContract.View rootView) {
        super(model, rootView);
    }


    public void login(String name,String pwd){
//        mModel.login(name,pwd)
//                .subscribeOn(Schedulers.io())
//                .retryWhen(new RetryWithDelay(1, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔.subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
//                .subscribe(new ErrorHandleSubscriber<WanUser>(mErrorHandler) {
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        super.onError(e);
////                        mRootView.initUser(null);
//                        Timber.i("login  "+e.getMessage());
//
//                        mRootView.loginFail(e.getMessage());
//                    }
//                    @Override
//                    public void onNext(WanUser userDetail) {
//                        mRootView.loginSuccess(userDetail);
//                    }
//                });

        mModel.login(name,pwd)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(1, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔.subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<BaseResponse<WanUser>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<WanUser> wanUserBaseResponse) {
                        mRootView.loginFail(wanUserBaseResponse.getErrorMsg());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        super.onError(e);
//                        mRootView.initUser(null);
                        Timber.i("login  "+e.getMessage());

                        mRootView.loginFail(e.getMessage());
                    }

                });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
