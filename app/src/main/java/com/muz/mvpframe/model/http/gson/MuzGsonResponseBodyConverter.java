package com.muz.mvpframe.model.http.gson;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.muz.mvpframe.model.http.function.Fault;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:24
 */

public final class MuzGsonResponseBodyConverter<T> implements Converter<ResponseBody,T> {
    private Gson gson;
    private final TypeAdapter<T> adapter;
     MuzGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter){
        this.gson=gson;
        this.adapter = adapter;
    }
    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        try {
            String body =value.string();
            JSONObject jsonObject = new JSONObject(body);
//           int code = jsonObject.optInt("code");
            int code = jsonObject.optInt("code");

            if (code==0){
                if (jsonObject.isNull("data")){
                    throw new RuntimeException("数据为空");
                }else {
                return adapter.fromJson(body);
                }
            } else if (code == 2){
                Log.e("code == 2","code == 2");
                String info = jsonObject.optString("info","");
                throw new Fault(code,info);
            }else {
                Log.e("code == else","code == else");
                String info = jsonObject.optString("info","");
                throw new RuntimeException(info);
            }
        } catch (JSONException e) {
            Log.e("JSONException","JSONException");
            throw new RuntimeException(e.getMessage());
        }finally {
            value.close();
        }
    }
}
