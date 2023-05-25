package cz.mendelu.pef.app_test_1.database

import cz.mendelu.pef.app_test_1.model.Car as Item
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

    override suspend fun getItemById(id: Long): Item {
        return dao.getItemById(id)
    }

}