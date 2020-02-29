package com.brianphiri.gossip.dataAccess

import android.content.Context
import com.brianphiri.gossip.dataSource.room.EventLogs
import com.brianphiri.gossip.dataSource.room.InternalDatabase
import com.brianphiri.gossip.dataSource.send
import com.brianphiri.gossip.util.isOnline
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun writeToInternalDatabase(context: Context, data: String) {
    GlobalScope.launch {
        val dao = InternalDatabase(context).eventLogsDao()
        val request = EventLogs()
        request.report = data
        dao.recordLog(request)
    }
}

fun checkIfDatabaseHasData(context: Context) {
    GlobalScope.launch {
        val dao = InternalDatabase(context).eventLogsDao()
        val logs = dao.getAllLogs()
        if(logs.isNotEmpty()){
            for (i in logs) {
                if(isOnline(context)){
                    send(i.report)
                    dao.removeLog(i.id)
                } else {
                    break
                }
            }
        }
    }
}