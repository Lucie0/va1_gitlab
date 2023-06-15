package cz.mendelu.pef.dostihyasazky.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.mendelu.pef.dostihyasazky.model.*

@Database(
    entities = [Card::class, SavedGame::class, Transaction::class, CardType::class, PaymentType::class, MoreDetails::class],
    version = 2,
    exportSchema = true
)
abstract class RacesBetsDatabase :
    RoomDatabase() { // abychom pracovali se soubory, potrebujeme context

    abstract fun rbDao(): RacesBetsDao // propojeni mezi db a daem

    companion object {
        private var INSTANCE: RacesBetsDatabase? = null

        fun getDatabase(context: Context): RacesBetsDatabase {
            if (INSTANCE == null) {
                synchronized(RacesBetsDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            RacesBetsDatabase::class.java,
                            "races_bets_database"
                        )//.addMigrations(MIGRATION_3_4)
//                            .fallbackToDestructiveMigration()
                            .createFromAsset("database/initDB.db")
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