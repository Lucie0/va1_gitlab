package cz.pef.mendelu.exam.database

import androidx.room.*
import cz.pef.mendelu.exam.model.Fault as Item
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {

    @Query("SELECT * FROM faults WHERE date >= :beforeYear ")
    fun getActualFaults(beforeYear: Long): Flow<List<Item>>

    // insert vraci id noveho, update pocet updatovanych, delete pocet smazanych zaznamu
    @Insert
    suspend fun insert(item: Item): Long

    @Query("SELECT * FROM faults WHERE id = :id")
    suspend fun getItemById(id: Long): Item

}