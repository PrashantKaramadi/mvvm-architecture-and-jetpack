package com.example.mvvm.data.api

import com.example.mvvm.data.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>
}