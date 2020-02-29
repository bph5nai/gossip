package com.brianphiri.gossip.dataAccess

import android.content.Context
import com.brianphiri.gossip.dataSource.send
import com.brianphiri.gossip.model.WsRequest
import com.brianphiri.gossip.util.getCurrentTime
import com.brianphiri.gossip.util.isOnline
import com.google.gson.Gson

class Whisper(private val context: Context) {
    fun whisper(actor: String, tag: String, resource: String, eventType: String, metadata : Map<String, Any> = mapOf()){
        val r = WsRequest()
        r.actor = actor
        r.resource = resource
        r.tag = tag
        r.eventType = eventType
        r.metadata = metadata
        r.time = getCurrentTime()

        val request = Gson().toJson(r)
        if(isOnline(context)) {
            send(Gson().toJson(r))
            checkIfDatabaseHasData(context)
        } else {
            writeToInternalDatabase(context, request)
        }
    }
}