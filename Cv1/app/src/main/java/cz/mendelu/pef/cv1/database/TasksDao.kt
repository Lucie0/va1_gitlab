package cz.mendelu.pef.cv1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cz.mendelu.pef.cv1.model.Task
import kotlinx.coroutines.flow.Flow

// pracuje s objekty
@Dao
interface TasksDao {
    // db operace se musi provadet na pozadi

    // flow posloucha nad zmenami, dava fci na pozadi
    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<Task>>

    // insert vraci id noveho, update pocet updatovanych, delete pocet smazanych zaznamu
    @Insert
    suspend fun insert(task: Task): Long
}