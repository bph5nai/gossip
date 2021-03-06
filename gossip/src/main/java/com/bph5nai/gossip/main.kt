package com.bph5nai.gossip

import android.content.Context
import com.bph5nai.gossip.dataAccess.Whisper

fun Context.whisper(actor: String, tag: String, resource: String, eventType: String, metadata : Map<String, Any> = mapOf()){
    Whisper(this).whisper(actor, tag, resource, eventType, metadata)
}