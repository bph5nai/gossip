package com.brianphiri.gossip

data class Request(
    var resource: String,
    var tag: String,
    var body: String,
    var metadata: String
) {
    constructor(): this("","","","")
}
