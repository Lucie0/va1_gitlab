package com.example.contactsapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.contactsapp.model.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    fun getAll(): Flow<List<Contact>>

    @Insert
    suspend fun insert(task: Contact): Long
}