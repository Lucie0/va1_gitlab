package cz.mendelu.pef.cv1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
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

    @Query("UPDATE tasks SET task_state = :taskState WHERE id = :id") // :nazev promenne ve fci
    suspend fun changeTaskState(id: Long, taskState: Boolean)
}