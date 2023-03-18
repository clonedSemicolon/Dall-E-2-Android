package com.clonedsemicolon.dalle2_android.domain.dependency

import com.clonedsemicolon.dalle2_android.common.Constants
import com.clonedsemicolon.dalle2_android.data.source.service.DallEImageGenerateService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitDependency {

    private var dallE:OkHttpClient = OkHttpClient.Builder().addInterceptor{
        val req:Request = it.request().newBuilder().addHeader("Content-Type","application/json").
        addHeader("authorization","${Constants.TOKEN}").build()
        it.proceed(req)
    }.build()

    @Provides
    @Singleton
    fun provideDalE():DallEImageGenerateService = Retrofit.Builder().client(dallE).baseUrl(Constants.DALL_E_BASE_URL).addConverterFactory(
       GsonConverterFactory.create()).build().create(DallEImageGenerateService::class.java)

}