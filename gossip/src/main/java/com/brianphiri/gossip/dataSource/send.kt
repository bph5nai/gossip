package com.brianphiri.gossip.dataSource

import com.brianphiri.gossip.dataSource.ws.wsConnectionClient

fun send(req: String) {
    val request = wsConnectionClient()
    request.client.newWebSocket(request.request, listener(req))
    request.client.dispatcher().executorService().shutdown()
}
