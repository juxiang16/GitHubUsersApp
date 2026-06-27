package com.example.githubusersapp.data.model

data class DetailUser(
    val login: String,
    val avatar_url: String,
    val name: String?,
    val bio: String?,
    val followers: Int,
    val following: Int,
    val public_repos: Int,
    val location: String?
)