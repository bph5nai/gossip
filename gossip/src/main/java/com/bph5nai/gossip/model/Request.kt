package com.bph5nai.gossip.model

data class WsRequest(
    var actor: String,
    var resource: String,
    var tag: String,
    var eventType: String,
    var metadata: Map<String, Any>,
    var time: String
) {
    constructor(): this("","","","", mapOf(), "")
}
