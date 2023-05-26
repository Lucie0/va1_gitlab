package cz.mendelu.pef.midterm2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.mendelu.pef.midterm2.model.Player as Item

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
                            MyDatabase::class.java, "players_database"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}