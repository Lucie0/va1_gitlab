package com.example.contactsapp.database

import com.example.contactsapp.model.Contact
import kotlinx.coroutines.flow.Flow

class ContactsRepositoryImpl(private val dao: ContactsDao) : IContactsRepository {
    override fun getAll(): Flow<List<Contact>> {
        return dao.getAll()
    }

    override suspend fun insert(contact: Contact): Long {
        return dao.insert(contact)
    }
}