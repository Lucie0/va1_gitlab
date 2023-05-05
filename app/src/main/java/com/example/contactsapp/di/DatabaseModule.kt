package com.example.contactsapp.di

import com.example.contactsapp.ContactsApplication
import com.example.contactsapp.database.ContactsDatabase
import org.koin.dsl.module

val databaseModule = module {
    //metoda, ktera bude vracet instanci
    fun provideDatabase(): ContactsDatabase {
        return ContactsDatabase.getDatabase(ContactsApplication.appContext)
    }

    single { provideDatabase() }
}
