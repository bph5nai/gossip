package com.brianphiri.gossip.dataSource.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_logs")
data class EventLogs (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var report: String
) {
    constructor() :this(0, "")
}