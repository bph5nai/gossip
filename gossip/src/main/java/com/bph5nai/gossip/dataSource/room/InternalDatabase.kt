package com.bph5nai.gossip.dataSource.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EventLogs::class], version = 1)
abstract class InternalDatabase: RoomDatabase() {
    abstract fun eventLogsDao(): EventLogsDao

    companion object {
        @Volatile private var instance: InternalDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            InternalDatabase::class.java, "test.db")
            .build()
    }
}

