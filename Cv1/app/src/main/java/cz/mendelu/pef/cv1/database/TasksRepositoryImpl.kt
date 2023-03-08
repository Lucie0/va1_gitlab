package cz.mendelu.pef.cv1.database

import cz.mendelu.pef.cv1.model.Task
import kotlinx.coroutines.flow.Flow

class TasksRepositoryImpl(private val dao: TasksDao) // dao se ziska v momente, kdy je potreba -- Dependency Injection
    : ITasksRepository {

    override fun getAll(): Flow<List<Task>> {
        return dao.getAll()
    }

    override suspend fun insert(task: Task): Long {
        return dao.insert(task)
    }
}