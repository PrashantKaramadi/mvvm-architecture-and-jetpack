package com.example.mvvm.views.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityPostsBinding
import com.example.mvvm.views.adapters.PostAdapter
import com.example.mvvm.views.viewmodels.PostViewModel

class PostsActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel
    private lateinit var postBinding: ActivityPostsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        postBinding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(postBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        postBinding.rvPosts.layoutManager = LinearLayoutManager(this)
        postViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(PostViewModel::class.java)

        postViewModel.posts.observe(this) { posts ->
            val adapter = PostAdapter(posts)
            postBinding.rvPosts.adapter = adapter

        }
    }
}