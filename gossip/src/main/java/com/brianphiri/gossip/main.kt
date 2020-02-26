package com.brianphiri.gossip

import com.brianphiri.gossip.dataAccess.Whisper

fun whisper(actor: String, tag: String, resource: String, eventType: String, metadata : Map<String, Any> = mapOf()){
    Whisper().whisper(actor, tag, resource, eventType, metadata)
}