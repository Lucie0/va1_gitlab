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

    override suspend fun changeTaskState(id: Long, taskState: Boolean) {
        return dao.changeTaskState(id, taskState)
    }

    override suspend fun getTaskById(id: Long): Task {
        return dao.getTaskById(id)
    }

    override suspend fun update(task: Task): Int {
        return dao.update(task)
    }

//    override suspend fun updateTask(id: Long, text: String): Long {
//        return dao.updateTask(id, text)
//    }

}