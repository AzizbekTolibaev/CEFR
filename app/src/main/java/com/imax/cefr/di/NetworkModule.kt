package com.imax.cefr.di

import com.imax.cefr.BuildConfig
import com.imax.cefr.core.base.interceptor.AccessTokenInterceptor
import com.imax.cefr.data.api.CefrApi
import com.imax.cefr.core.base.constants.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        getCefrService(retrofit = get())
    }

    single<Retrofit> {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = AccessTokenInterceptor(localStorage = get())

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(interceptor)
            .readTimeout(Constants.NETWORK_READ_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.NETWORK_WRITE_TIME_OUT, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()
    }
}

fun getCefrService(retrofit: Retrofit): CefrApi {
    return retrofit.create(CefrApi::class.java)
}
