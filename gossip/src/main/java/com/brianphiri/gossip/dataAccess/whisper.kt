package com.brianphiri.gossip.dataAccess

import android.content.Context
import com.brianphiri.gossip.dataSource.send
import com.brianphiri.gossip.model.WsRequest
import com.brianphiri.gossip.util.getCurrentTime
import com.brianphiri.gossip.util.isOnline
import com.google.gson.Gson

class Whisper {
    fun Context.whisper(actor: String, tag: String, resource: String, eventType: String, metadata : Map<String, Any> = mapOf()){
        val r = WsRequest()
        r.actor = actor
        r.resource = resource
        r.tag = tag
        r.eventType = eventType
        r.metadata = metadata
        r.time = getCurrentTime()

        val request = Gson().toJson(r)
        if(isOnline(this)) {
            send(Gson().toJson(r))
            checkIfDatabaseHasData(this)
        } else {
            writeToInternalDatabase(this, request)
        }
    }
}