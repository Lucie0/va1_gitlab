package cz.mendelu.pef.cv1.database

import cz.mendelu.pef.cv1.model.Task
import kotlinx.coroutines.flow.Flow

interface ITasksRepository {
    // pouze rozhrani
    fun getAll(): Flow<List<Task>>
    suspend fun insert(task: Task): Long
    suspend fun changeTaskState(id: Long, taskState: Boolean)
    suspend fun getTaskById(id: Long): Task
//    suspend fun updateTask(id: Long, text: String): Long
    suspend fun update(task: Task)
}