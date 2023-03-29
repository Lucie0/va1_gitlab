package cz.mendelu.pef.test1.database

import cz.mendelu.pef.test1.model.Word
import kotlinx.coroutines.flow.Flow

class WordsRepositoryImpl(private val dao: WordsDao) : IWordsRepository{
    override fun getAll(): Flow<List<Word>> {
        return dao.getAll()
    }

    override suspend fun insert(word: Word): Long {
        return dao.insert(word)
    }
}