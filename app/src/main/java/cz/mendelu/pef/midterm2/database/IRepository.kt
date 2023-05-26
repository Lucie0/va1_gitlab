package cz.mendelu.pef.midterm2.database

import cz.mendelu.pef.midterm2.model.Player as Item
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getAll(): Flow<List<Item>>
    suspend fun insert(item: Item): Long
    suspend fun update(item: Item)
    suspend fun delete(item: Item)

    suspend fun changeState(id: Long, state: Boolean)
    suspend fun getItemById(id: Long): Item
    //    suspend fun updateTask(id: Long, text: String): Long
}