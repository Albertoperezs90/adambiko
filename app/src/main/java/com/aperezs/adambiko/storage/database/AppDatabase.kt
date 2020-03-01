package com.aperezs.adambiko.storage.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aperezs.adambiko.storage.dao.EntryDAO
import com.aperezs.adambiko.storage.model.EntryEntity

@androidx.room.Database(entities = [EntryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun entryDAO(): EntryDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return if (INSTANCE != null) INSTANCE!!
            else {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "entry_database"
                    ).build()
                    INSTANCE = instance
                    return INSTANCE!!
                }
            }
        }

    }


}