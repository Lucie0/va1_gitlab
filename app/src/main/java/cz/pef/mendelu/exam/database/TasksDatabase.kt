package cz.pef.mendelu.exam.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.pef.mendelu.exam.model.Fault as Item

@Database(entities = [Item::class], version = 2, exportSchema = true)
abstract class TasksDatabase : RoomDatabase() { // abychom pracovali se soubory, potrebujeme context

    abstract fun myDao(): TasksDao // propojeni mezi db a daem

    companion object {
        private var INSTANCE: TasksDatabase? = null

        fun getDatabase(context: Context): TasksDatabase {
            if (INSTANCE == null) {
                synchronized(TasksDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            TasksDatabase::class.java, "faults_database"
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