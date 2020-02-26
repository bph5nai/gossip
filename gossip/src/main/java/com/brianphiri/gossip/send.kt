package com.brianphiri.gossip

import okhttp3.OkHttpClient
import okhttp3.Request

fun send(req: String) {
    val client = OkHttpClient()
    val request = Request.Builder().url("ws://192.168.43.169:8080/ws").build()
    client.newWebSocket(request, listener(req))
    client.dispatcher().executorService().shutdown()
}

