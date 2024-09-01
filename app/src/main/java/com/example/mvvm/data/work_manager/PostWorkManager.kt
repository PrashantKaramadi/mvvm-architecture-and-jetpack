package com.example.mvvm.data.work_manager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters


class PostWorkManager(private var context: Context, private var params: WorkerParameters) :
    Worker(context, params) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}