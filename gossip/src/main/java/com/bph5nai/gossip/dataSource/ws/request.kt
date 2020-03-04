package com.bph5nai.gossip.dataSource.ws

import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception

fun wsConnectionClient(): WsClient? {
    val client = OkHttpClient()
    return try {
        val request = Request.Builder().url(ws.ENDPOINT).build()
        WsClient(client, request)
    } catch (e: Exception) {
        null
    }
}