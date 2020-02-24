package com.brianphiri.gossip

import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener


fun listener(request: String) = object : WebSocketListener() {
    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        webSocket.send(request)
        output("open $response")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        Log.i("information message", text)
        output("Message received: $text")

    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
        Log.i("information closing", reason)
        output("closing: $reason")
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosed(webSocket, code, reason)
        Log.i("information closed", reason)
        output("closed: $reason")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
        Log.i("information failure", t.message!!)
        output("Failure ${t.message}")
    }
}


private fun output(string: String): String{
    return string
}