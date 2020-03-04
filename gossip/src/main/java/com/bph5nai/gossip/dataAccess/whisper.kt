package com.bph5nai.gossip.dataAccess

import android.content.Context
import com.bph5nai.gossip.dataSource.send
import com.bph5nai.gossip.model.WsRequest
import com.bph5nai.gossip.util.getCurrentTime
import com.bph5nai.gossip.util.isOnline
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
            context.send(Gson().toJson(r))
            checkIfDatabaseHasData(context)
        } else {
            writeToInternalDatabase(context, request)
        }
    }
}