package com.example.mvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
class Post(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var userId: Int,
    var title: String,
    var body: String)