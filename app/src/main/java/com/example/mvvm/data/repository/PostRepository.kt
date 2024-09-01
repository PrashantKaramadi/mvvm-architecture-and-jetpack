package com.example.mvvm.data.repository

import com.example.mvvm.data.model.Post
import com.example.mvvm.data.api.RetrofitInstance
import com.example.mvvm.data.dao.PostDao
import com.example.mvvm.data.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Call

class PostRepository(private val postDao: PostDao) {
    private var apiService = RetrofitInstance.apiService

    fun getPosts(): Call<List<Post>> {
        return apiService.getPosts()
    }

    suspend fun insertData(posts: List<Post>) {
        println(posts)
        postDao.insertData(posts)
    }

    suspend fun getPostsFromDB() : List<Post>{
       return withContext(Dispatchers.IO){
           postDao.getPosts()
       }
    }

    suspend fun deleteAllPosts() {
        postDao.deleteAll()
    }
}