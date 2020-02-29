package com.brianphiri.gossip

import androidx.work.ListenableWorker
import com.brianphiri.gossip.dataAccess.Whisper
import com.brianphiri.gossip.dataSource.room.EventLogs
import com.brianphiri.gossip.dataSource.room.InternalDatabase
import com.brianphiri.gossip.util.isOnline

fun whisper(actor: String, tag: String, resource: String, eventType: String, metadata : Map<String, Any> = mapOf()){
    Whisper().whisper(actor, tag, resource, eventType, metadata)
}