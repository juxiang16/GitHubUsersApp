package com.example.githubusersapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(
                "https://api.github.com/"
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

    val api: GitHubApi =
        retrofit.create(
            GitHubApi::class.java
        )
}