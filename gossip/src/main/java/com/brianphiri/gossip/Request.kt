package com.brianphiri.gossip

data class Request(
    var actor: String,
    var resource: String,
    var tag: String,
    var eventType: String,
    var metadata: String
) {
    constructor(): this("","","","", "")
}
