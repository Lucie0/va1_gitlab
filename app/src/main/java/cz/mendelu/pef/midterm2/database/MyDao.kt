package cz.mendelu.pef.midterm2.database

import androidx.room.*
import cz.mendelu.pef.midterm2.model.Player as Item
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Query("SELECT * FROM players")
    fun getAll(): Flow<List<Item>>

    // insert vraci id noveho, update pocet updatovanych, delete pocet smazanych zaznamu
    @Insert
    suspend fun insert(item: Item): Long

    // anotace @update si sestavi dotaz sama a nahradi zaznam v DB
    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM players WHERE id = :id")
    suspend fun getItemById(id: Long): Item

    @Query("UPDATE players SET on_match = :state WHERE id = :id")
    suspend fun changeState(id: Long, state: Boolean)


}