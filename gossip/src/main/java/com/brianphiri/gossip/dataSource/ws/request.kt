package com.brianphiri.gossip.dataSource.ws

import okhttp3.OkHttpClient
import okhttp3.Request

fun wsConnectionClient(): WsClient {
    val client = OkHttpClient()
    val request = Request.Builder().url(ws.ENDPOINT).build()
    return WsClient(client, request)
}