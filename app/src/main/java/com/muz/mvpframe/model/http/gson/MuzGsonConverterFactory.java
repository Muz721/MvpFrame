package com.muz.mvpframe.model.http.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


/**
 * @description
 * @author  Muz
 * @date  2018/10/18 16:24
 */

public final class MuzGsonConverterFactory extends Converter.Factory{

    public static MuzGsonConverterFactory create() {
        return create(new Gson());
    }


    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public static MuzGsonConverterFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        return new MuzGsonConverterFactory(gson);
    }

    private final Gson gson;

    private MuzGsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new MuzGsonResponseBodyConverter<>(gson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new MuzGsonRequestBodyConverter<>(gson, adapter);
    }

}
