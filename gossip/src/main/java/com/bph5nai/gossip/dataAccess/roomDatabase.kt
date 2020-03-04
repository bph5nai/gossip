package com.bph5nai.gossip.dataAccess

import android.content.Context
import com.bph5nai.gossip.dataSource.room.EventLogs
import com.bph5nai.gossip.dataSource.room.InternalDatabase
import com.bph5nai.gossip.dataSource.send
import com.bph5nai.gossip.util.isOnline
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
                    context.send(i.report)
                    dao.removeLog(i.id)
                } else {
                    break
                }
            }
        }
    }
}