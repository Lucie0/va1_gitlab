package cz.mendelu.pef.app_test_1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.mendelu.pef.hw2.database.MyDao
import cz.mendelu.pef.hw2.model.Contact as Item

// 2--3 params,
// verze -- aktualni schema, rict, jake jsou zmeny -- migrace ze vsech verzi, ktere muze mit uzivatel nainstalovane,
// pred . build lze vlozit .fallbackToDestructiveMigration() -- zajisteni smazani db a nasazeni nove
// exportSchema -- exportovani schematu db, kdyz to spadne -- zjistovani create table
@Database(entities = [Item::class], version = 1, exportSchema = true)
abstract class MyDatabase : RoomDatabase() { // abychom pracovali se soubory, potrebujeme context

    abstract fun myDao(): MyDao // propojeni mezi db a daem

    companion object {
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            if (INSTANCE == null) {
                synchronized(MyDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MyDatabase::class.java, "contacts_database"
                        )//.addMigrations(MIGRATION_3_4)
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }

//        // migrace db
//        private val MIGRATION_3_4: Migration = object : Migration(3,4) { // odkud_kam
//            override fun migrate(database: SupportSQLiteDatabase) {
//                // primy pristup do db
//                // pridani sloupcu do db
//                database.execSQL("ALTER TABLE tasks ADD COLUMN latitude REAL")
//                database.execSQL("ALTER TABLE tasks ADD COLUMN longitude REAL")
//            }
//
//        }
    }
}
