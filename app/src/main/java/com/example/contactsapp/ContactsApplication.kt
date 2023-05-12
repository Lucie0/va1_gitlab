package com.example.contactsapp

import android.app.Application
import android.content.Context
import com.example.contactsapp.di.daoModule
import com.example.contactsapp.di.databaseModule
import com.example.contactsapp.di.repositoryModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ContactsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin{
            androidContext(this@ContactsApplication)
            modules(listOf(
                // seznam modulu
                // todo moduly
//                viewModelModule,
                repositoryModule,
                daoModule,
                databaseModule
            ))
        }
    }

    companion object {
        lateinit var appContext: Context private set // do contextu se NIKDY nesmi zapisovat

    }
}