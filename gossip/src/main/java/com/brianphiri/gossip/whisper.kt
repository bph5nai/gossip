package com.brianphiri.gossip

fun whisper(resource: String, tag: String="", body : Map<String, Any> = mapOf(), metadata : Map<String, Any> = mapOf()){

    val r = Request()
    r.resource = resource
    r.tag = tag
    r.body = body.toString()
    r.metadata = metadata.toString()

    send(r)
}