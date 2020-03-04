//package com.bph5nai.gossip.worker
//
//import android.content.Context
//import androidx.work.Worker
//import androidx.work.WorkerParameters
//import com.bosch.appcrunch.playground.internetConnection.isOnline
//import com.bosch.appcrunch.playground.room.EventLogs
//import com.bosch.appcrunch.playground.room.InternalDatabase
//import kotlinx.coroutines.runBlocking
//import java.lang.Exception
//
//class PostFromRoom(context: Context, params: WorkerParameters) : Worker(context, params) {
//    override fun doWork(): Result {
//        return try {
//            runBlocking {
//                val dao = InternalDatabase(applicationContext).eventLogsDao()
//                val data = dao.getAllLogs()
//                for (i in data) {
//                    if(isOnline(applicationContext)){
//                        // send i.report
//                        // delete i from room
//                    } else {
//                        break
//                    }
//                }
//            }
//            Result.success()
//        } catch (e: Exception) {
//            Result.retry()
//        }
//    }
//}