package cz.mendelu.pef.hw2.database

import cz.mendelu.pef.hw2.model.Contact as Item
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getAll(): Flow<List<Item>>
    suspend fun insert(item: Item): Long
    suspend fun update(item: Item)
    suspend fun delete(item: Item)

//    suspend fun changeTaskState(id: Long, taskState: Boolean)
    suspend fun getItemById(id: Long): Item
    //    suspend fun updateTask(id: Long, text: String): Long


}