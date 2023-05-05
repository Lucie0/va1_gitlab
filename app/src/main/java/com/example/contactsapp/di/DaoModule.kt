package com.example.contactsapp.di

import com.example.contactsapp.database.ContactsDao
import com.example.contactsapp.database.ContactsDatabase
import org.koin.dsl.module

val daoModule = module {

    //metoda, ktera bude vracet instanci
    fun provideDao(database: ContactsDatabase) : ContactsDao {// resim pouze, co vracim a co k tomu potrebuju
        return database.contactsDao()
    }

    single { provideDao(get()) }
}