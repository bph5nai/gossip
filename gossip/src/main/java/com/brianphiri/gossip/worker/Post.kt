package com.brianphiri.gossip.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.runBlocking
import java.lang.Exception

class Post(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            val data = inputData
            val jsonString = data.getString("log")
            runBlocking {

            }
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}