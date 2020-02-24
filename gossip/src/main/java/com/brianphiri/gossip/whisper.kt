package com.brianphiri.gossip

import com.google.gson.Gson
import org.json.JSONObject

fun whisper(resource: String, tag: String="", b : Map<String, Any> = mapOf(), m : Map<String, Any> = mapOf()){

    val r = Request()
    val body = JSONObject(b).toString()
    val metadata = JSONObject(m).toString()
    r.resource = resource
    r.tag = tag
    r.body = body
    r.metadata = metadata


    val jsonString = Gson().toJson(r)

    send(jsonString)
}