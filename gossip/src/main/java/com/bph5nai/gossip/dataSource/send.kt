package com.bph5nai.gossip.dataSource

import android.content.Context
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.bph5nai.gossip.util.postDataConstraints
import com.bph5nai.gossip.worker.Post

fun Context.send(req: String) {
    val builder = Data.Builder()
    builder.putString("logs", req)
    val recordLog = OneTimeWorkRequest.Builder(Post::class.java)
        .setInputData(builder.build())
        .setConstraints(postDataConstraints)
        .build()
    WorkManager.getInstance(this).enqueueUniqueWork(
        "logs",
        ExistingWorkPolicy.REPLACE,
        recordLog
    )
}

