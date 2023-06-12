package cz.pef.mendelu.exam.database

import cz.pef.mendelu.exam.model.Fault as Item
import kotlinx.coroutines.flow.Flow
import java.time.Year

interface ILocalRepository {
//    fun getAll(): Flow<List<Item>>
    fun getActualFaults(beforeYear: Long): Flow<List<Item>>

    suspend fun insert(item: Item): Long

    suspend fun getItemById(id: Long): Item
}