package com.example.mvvm.network.repository

import com.example.mvvm.model.Post
import com.example.mvvm.network.api.RetrofitInstance
import retrofit2.Call

class PostRepository {
    private var apiService = RetrofitInstance.apiService

    fun getPosts(): Call<List<Post>> {
        return apiService.getPosts()
    }
}