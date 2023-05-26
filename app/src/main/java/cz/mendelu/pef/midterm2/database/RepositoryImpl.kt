package cz.mendelu.pef.midterm2.database

import cz.mendelu.pef.midterm2.model.Player as Item
import kotlinx.coroutines.flow.Flow


class RepositoryImpl(private val dao: MyDao) : IRepository {
    override fun getAll(): Flow<List<Item>> {
        return dao.getAll()
    }

    override suspend fun insert(item: Item): Long {
        return dao.insert(item)
    }

    override suspend fun update(item: Item) {
        return dao.update(item)
    }

    override suspend fun delete(item: Item) {
        return dao.delete(item)
    }

    override suspend fun changeState(id: Long, state: Boolean) {
        return dao.changeState(id, state)
    }

    override suspend fun getItemById(id: Long): Item {
        return dao.getItemById(id)
    }

}