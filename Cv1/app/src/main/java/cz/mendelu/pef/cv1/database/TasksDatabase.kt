package cz.mendelu.pef.cv1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.mendelu.pef.cv1.model.Task

// 2--3 params,
// verze -- aktualni schema, rict, jake jsou zmeny -- migrace ze vsech verzi, ktere muze mit uzivatel nainstalovane,
// pred . build lze vlozit .fallbackToDestructiveMigration() -- zajisteni smazani db a nasazeni nove
// exportSchema -- exportovani schematu db, kdyz to spadne -- zjistovani create table
@Database(entities = [Task::class], version = 2, exportSchema = true)
abstract class TasksDatabase : RoomDatabase() { // abychom pracovali se soubory, potrebujeme context

    abstract fun tasksDao(): TasksDao // propojeni mezi db a daem

    companion object {
        private var INSTANCE: TasksDatabase? = null
        fun getDatabase(context: Context): TasksDatabase {
            if (INSTANCE == null) {
                synchronized(TasksDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            TasksDatabase::class.java, "tasks_database"
                        ).fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}