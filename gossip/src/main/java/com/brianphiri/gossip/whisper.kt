package com.brianphiri.gossip

import com.google.gson.Gson
import org.json.JSONObject

fun whisper(actor: String, tag: String, resource: String, eventType: String, metadata : Map<String, Any> = mapOf()){
    val r = Request()
    r.resource = resource
    r.tag = tag
    r.eventType = eventType
    r.metadata = JSONObject(metadata).toString()
    val jsonString = Gson().toJson(r)
    send(jsonString)
}