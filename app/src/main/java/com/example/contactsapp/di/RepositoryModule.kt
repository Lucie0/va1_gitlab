package com.example.contactsapp.di

import com.example.contactsapp.database.ContactsDao
import com.example.contactsapp.database.ContactsRepositoryImpl
import com.example.contactsapp.database.IContactsRepository
import org.koin.dsl.module

val repositoryModule = module {

    //metoda, ktera bude vracet instanci
    fun provideContactsRepository(dao: ContactsDao): IContactsRepository {
        return ContactsRepositoryImpl(dao)
    }

    // metoda
    single { provideContactsRepository(get()) } // ziskani dao

}