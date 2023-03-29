package cz.mendelu.pef.test1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cz.mendelu.pef.test1.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {
    @Query("SELECT * FROM words")
    fun getAll(): Flow<List<Word>>

    @Insert
    suspend fun insert(word: Word): Long
}