package me.jessyan.mvparms.demo.mvp.model.api.service;

import java.util.List;

import io.reactivex.Observable;
import me.jessyan.mvparms.demo.mvp.model.api.Api;
import me.jessyan.mvparms.demo.mvp.model.entity.BaseResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.User;
import me.jessyan.mvparms.demo.usercenter.login.di.module.entity.WanUser;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

public interface LoginService {
   String HEADER_API_VERSION = "Accept: application/vnd.github.v3+json";

    @Headers({HEADER_API_VERSION})
    @GET("/login")
    Observable<String> login1(@Query("name") String name, @Query("pwd") String pwd);

    @Headers({DOMAIN_NAME_HEADER+ Api.WAN})
    @POST("/user/login")
    @FormUrlEncoded
    Observable<BaseResponse<WanUser>> login(@Field("username") String username, @Field("password") String password);
}
