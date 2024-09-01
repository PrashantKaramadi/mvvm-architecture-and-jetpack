package com.example.mvvm.network.api

import com.example.mvvm.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>
}