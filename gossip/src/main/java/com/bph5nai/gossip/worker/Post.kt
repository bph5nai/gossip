package com.bph5nai.gossip.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.bph5nai.gossip.dataSource.listener
import com.bph5nai.gossip.dataSource.ws.wsConnectionClient
import kotlinx.coroutines.runBlocking
import java.lang.Exception

class Post(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            val data = inputData
            val jsonString = data.getString("logs")!!
            runBlocking {
                val request = wsConnectionClient()
                if(request != null) {
                    request.client.newWebSocket(request.request, listener(jsonString))
                    request.client.dispatcher.executorService.shutdown()
                }
            }
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}