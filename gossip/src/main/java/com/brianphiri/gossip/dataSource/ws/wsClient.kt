package com.brianphiri.gossip.dataSource.ws

import okhttp3.OkHttpClient
import okhttp3.Request

class WsClient(
    var client: OkHttpClient,
    var request: Request
)