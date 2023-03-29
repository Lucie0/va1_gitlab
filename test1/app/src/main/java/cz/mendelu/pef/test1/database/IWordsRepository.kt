package cz.mendelu.pef.test1.database

import cz.mendelu.pef.test1.model.Word
import kotlinx.coroutines.flow.Flow

interface IWordsRepository {
    fun getAll(): Flow<List<Word>>
    suspend fun insert(word: Word): Long
}