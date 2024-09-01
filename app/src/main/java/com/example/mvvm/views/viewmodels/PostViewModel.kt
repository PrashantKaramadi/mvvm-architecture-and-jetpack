package com.example.mvvm.views.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.dao.PostDao
import com.example.mvvm.data.model.Post
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.repository.PostRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel(postDao: PostDao) : ViewModel() {

    private var postRepository = PostRepository(postDao)

    var postList = MutableLiveData<List<Post>>()
    var posts: LiveData<List<Post>> = postList


    init {
        getPost()
    }

    private fun getPost() {
        postRepository.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    postList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }

        })
    }

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                postRepository.getPostsFromDB()
            } catch (e: Exception) {
                Log.d("TAG", "fetchPosts: ${e.message}")
            }
        }
    }

    fun insertPosts(posts: List<Post>) {
        viewModelScope.launch {
            postRepository.insertData(posts)
        }
    }

}