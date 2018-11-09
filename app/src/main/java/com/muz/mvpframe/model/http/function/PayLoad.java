package com.muz.mvpframe.model.http.function;


import com.muz.mvpframe.base.BaseResponse;

import io.reactivex.functions.Function;

/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:24
 */

public class PayLoad<T> implements Function<BaseResponse<T>, T> {
    @Override
    public T apply(BaseResponse<T> baseResponse) throws Exception {
        if(baseResponse.getCode()==0){
        return baseResponse.getData();
        }
            throw new Fault(baseResponse.getCode(),baseResponse.getInfo());
    }
}
