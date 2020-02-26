package com.brianphiri.gossip.dataAccess

import com.brianphiri.gossip.dataSource.send
import com.brianphiri.gossip.model.WsRequest
import com.brianphiri.gossip.util.getCurrentTime
import com.google.gson.Gson

class Whisper {
    fun whisper(actor: String, tag: String, resource: String, eventType: String, metadata : Map<String, Any> = mapOf()){
        val r = WsRequest()
        r.actor = actor
        r.resource = resource
        r.tag = tag
        r.eventType = eventType
        r.metadata = metadata
        r.time = getCurrentTime()
        send(Gson().toJson(r))
    }
}