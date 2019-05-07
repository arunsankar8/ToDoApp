package com.example.todoapps.api

import com.google.gson.GsonBuilder
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory

import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Injection {
    companion object {


        private const val CACHE_CONTROL = "Cache-Control"

        private fun getOkHttpClient(): OkHttpClient {

            return OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(provideCacheInterceptor())
                .build()
        }

        private fun provideCacheInterceptor(): Interceptor {
            return Interceptor { chain ->
                val response = chain.proceed(chain.request())

                // re-write response header to force use of cache
                val cacheControl = CacheControl.Builder()
                    .maxAge(2, TimeUnit.MINUTES)
                    .build()

                response.newBuilder()
                    .header(CACHE_CONTROL, cacheControl.toString())
                    .build()
            }
        }

        var gson = GsonBuilder()
            .setLenient()
            .create()

        private fun provideRetrofit(): Retrofit {
            val httpClient = getOkHttpClient()

            return Retrofit.Builder()
                .baseUrl("https://192.168.20.223:8000/api/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build()
        }

        fun provideApiService(): ApiService {
            return provideRetrofit()
                .create(ApiService::class.java)
        }
    }
}