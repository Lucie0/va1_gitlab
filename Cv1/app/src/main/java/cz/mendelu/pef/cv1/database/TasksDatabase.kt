package cz.mendelu.pef.cv1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import cz.mendelu.pef.cv1.model.Task

// 2--3 params,
// verze -- aktualni schema, rict, jake jsou zmeny -- migrace ze vsech verzi, ktere muze mit uzivatel nainstalovane,
// pred . build lze vlozit .fallbackToDestructiveMigration() -- zajisteni smazani db a nasazeni nove
// exportSchema -- exportovani schematu db, kdyz to spadne -- zjistovani create table
@Database(entities = [Task::class], version = 4, exportSchema = true)
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
                        ).addMigrations(MIGRATION_3_4)
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }

        // migrace db
        private val MIGRATION_3_4: Migration = object : Migration(3,4) { // odkud_kam
            override fun migrate(database: SupportSQLiteDatabase) {
                // primy pristup do db
                // pridani sloupcu do db
                database.execSQL("ALTER TABLE tasks ADD COLUMN latitude REAL")
                database.execSQL("ALTER TABLE tasks ADD COLUMN longitude REAL")
            }

        }
    }
}