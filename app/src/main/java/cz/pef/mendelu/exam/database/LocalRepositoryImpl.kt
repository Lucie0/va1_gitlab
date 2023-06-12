package cz.pef.mendelu.exam.database

import cz.pef.mendelu.exam.model.Fault
import kotlinx.coroutines.flow.Flow

class LocalRepositoryImpl(private val dao: TasksDao) : ILocalRepository {
    override fun getActualFaults(beforeYear: Long): Flow<List<Fault>> {
        return dao.getActualFaults(beforeYear)
    }

    override suspend fun insert(item: Fault): Long {
        return dao.insert(item)
    }

    override suspend fun getItemById(id: Long): Fault {
        return dao.getItemById(id)
    }

}