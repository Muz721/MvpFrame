package com.muz.mvpframe.di.module;




import com.muz.mvpframe.di.scope.ApiScope;
import com.muz.mvpframe.model.http.Api;
import com.muz.mvpframe.model.http.gson.MuzGsonConverterFactory;
import com.muz.mvpframe.model.http.response.HttpCommonInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author Muz
 * @description 网络请求
 * @date 2018/10/18 16:44
 */
@Module
public class ApiModule {
    @ApiScope
    @Provides
    Api provideService(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @ApiScope
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, Api.BASE_URL);
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient, String url) {
        return builder.baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MuzGsonConverterFactory.create())
                .build();
    }

    @ApiScope
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @ApiScope
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @ApiScope
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        // 添加公共参数拦截器
        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
//                .addHeaderParams("paltform","android")
                .build();
        //设置拦截器
        builder.addInterceptor(commonInterceptor);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

}
