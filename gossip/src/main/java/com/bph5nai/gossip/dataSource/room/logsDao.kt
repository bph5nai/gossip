package com.bph5nai.gossip.dataSource.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventLogsDao {
    @Query("SELECT * FROM event_logs")
    fun getAllLogs(): List<EventLogs>

    @Insert
    fun recordLog(vararg eventLogs: EventLogs)

    @Query("DELETE FROM event_logs WHERE id = :id")
    fun removeLog(id: Long)
}