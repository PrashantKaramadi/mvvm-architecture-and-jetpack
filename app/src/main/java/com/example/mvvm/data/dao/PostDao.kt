package com.example.mvvm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm.data.model.Post

@Dao
interface PostDao {

    @Insert
    suspend fun insertData(post: List<Post>)

    @Query("SELECT * From posts")
    suspend fun getPosts(): List<Post>

    @Query("DELETE FROM posts")
    suspend fun deleteAll()

}