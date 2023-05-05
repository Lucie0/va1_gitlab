package com.example.contactsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.contactsapp.model.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = true)
abstract class ContactsDatabase : RoomDatabase() {

    abstract fun contactsDao(): ContactsDao

    companion object {
        private var INSTANCE: ContactsDatabase? = null
        fun getDatabase(context: Context): ContactsDatabase {
            if (INSTANCE == null) {
                synchronized(ContactsDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ContactsDatabase::class.java, "contacts_database"
                        )//.addMigrations(MIGRATION_3_4)
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}