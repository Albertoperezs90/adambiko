package com.aperezs.adambiko.storage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aperezs.adambiko.storage.model.EntryEntity

@Dao
interface EntryDAO {

    @Query("SELECT * from entry")
    fun getAllEntries(): List<EntryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: EntryEntity)

    @Delete
    suspend fun deleteEntry(entry: EntryEntity)

    @Update
    suspend fun updateEntry(entry: EntryEntity)

    @Query("DELETE FROM entry")
    suspend fun deleteAll()

}