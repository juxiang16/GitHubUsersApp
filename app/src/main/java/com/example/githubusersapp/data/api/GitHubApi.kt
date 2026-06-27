package com.example.githubusersapp.data.api

import com.example.githubusersapp.data.model.User
import com.example.githubusersapp.data.model.DetailUser
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("users")
    suspend fun getUsers(): List<User>
    @GET("users/{login}")
    suspend fun getUser(
        @Path("login")
        login: String
    ): DetailUser
}