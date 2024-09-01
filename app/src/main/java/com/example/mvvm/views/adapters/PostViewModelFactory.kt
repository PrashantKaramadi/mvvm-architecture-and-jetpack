package com.example.mvvm.views.adapters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.dao.PostDao
import com.example.mvvm.views.viewmodels.PostViewModel


class PostViewModelFactory(private val postDao: PostDao) : ViewModelProvider.Factory {

    // Override the create method with the correct type signature
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Check if the provided modelClass is assignable from PostViewModel
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            // Create and return an instance of PostViewModel
            @Suppress("UNCHECKED_CAST")
            return PostViewModel(postDao) as T
        }
        // Throw an exception if the provided modelClass is not assignable
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}