package com.example.contactsapp.database

import com.example.contactsapp.model.Contact
import kotlinx.coroutines.flow.Flow

interface IContactsRepository {
    fun getAll(): Flow<List<Contact>>
    suspend fun insert(contact: Contact): Long
}