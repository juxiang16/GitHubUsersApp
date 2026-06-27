package com.example.githubusersapp.data.repository

import com.example.githubusersapp.data.api.RetrofitProvider
import com.example.githubusersapp.data.model.User
import com.example.githubusersapp.data.model.DetailUser

class UserRepository {

    private val api =
        RetrofitProvider.api

    suspend fun getUsers(): List<User> {
        return api.getUsers()
    }
    suspend fun getUser(login: String): DetailUser {
        return api.getUser(login)
    }
}