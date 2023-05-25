package cz.mendelu.pef.app_test_1.database

import cz.mendelu.pef.app_test_1.model.Car as Item
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