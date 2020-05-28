package me.jessyan.mvparms.demo.usercenter.login.mvp.model;

import android.app.Application;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;
import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import me.jessyan.mvparms.demo.mvp.model.api.service.LoginService;
import me.jessyan.mvparms.demo.mvp.model.entity.BaseResponse;
import me.jessyan.mvparms.demo.usercenter.login.di.module.entity.WanUser;
import me.jessyan.mvparms.demo.usercenter.login.mvp.contract.LoginContract;


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
public class LoginModel extends BaseModel implements LoginContract.Model{
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public LoginModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    /**
     * 具体发送网络请求
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public   Observable<BaseResponse<WanUser>> login(String name, String pwd) {
        Observable<BaseResponse<WanUser>> datas = mRepositoryManager.obtainRetrofitService(LoginService.class).login(name, pwd);
        return datas;
    }
}