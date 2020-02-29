package com.brianphiri.gossip.dataSource.room

class EventsLogRepository(private val eventLogsDao: EventLogsDao) {
    val allLogs: List<EventLogs> = eventLogsDao.getAllLogs()

    suspend fun insert(eventLogs: EventLogs) {
        eventLogsDao.recordLog(eventLogs)
    }
    fun remove(id :Long){
        eventLogsDao.removeLog(id)
    }
}