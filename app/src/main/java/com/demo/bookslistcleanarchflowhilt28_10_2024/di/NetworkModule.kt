package com.demo.bookslistcleanarchflowhilt28_10_2024.di

import com.demo.bookslistcleanarchflowhilt28_10_2024.network.ApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    private fun provideRetrofit(okHttpClient:OkHttpClient,gsonConverterFactory: GsonConverterFactory):Retrofit
      = Retrofit.Builder().baseUrl("https://softwium.com/api/")
          .client(okHttpClient)
          .addConverterFactory(gsonConverterFactory)
          .build()


    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient =
        OkHttpClient().newBuilder()
            .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    fun getApiService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)
}
