package com.bosch.appcrunch.playground.workermanager

data class Request(
    var actor: String,
    var resource: String,
    var tag: String,
    var eventType: String,
    var metadata: Map<String, Any>,
    var time: String
) {
    constructor(): this("","","","", mapOf(), "")
}