package com.brianphiri.gossip.dataSource

import com.brianphiri.gossip.dataSource.ws.wsRequest

fun send(req: String) {
    val request = wsRequest()
    request.client.newWebSocket(request.request, listener(req))
    request.client.dispatcher().executorService().shutdown()
}

