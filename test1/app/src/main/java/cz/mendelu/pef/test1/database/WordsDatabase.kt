package cz.mendelu.pef.test1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.mendelu.pef.test1.model.Word

@Database(entities = [Word::class], version = 1, exportSchema = true)
abstract class WordsDatabase : RoomDatabase() {
    abstract fun wordsDao(): WordsDao // propojeni mezi db a daem

    companion object {
        private var INSTANCE: WordsDatabase? = null
        fun getDatabase(context: Context): WordsDatabase {
            if (INSTANCE == null) {
                synchronized(WordsDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            WordsDatabase::class.java, "words_database"
                        ).fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}