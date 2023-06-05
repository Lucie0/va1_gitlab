package cz.mendelu.pef.hw2.database

import androidx.room.*
import cz.mendelu.pef.hw2.model.Contact as Item
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Query("SELECT * FROM contacts")
    fun getAll(): Flow<List<Item>>

    // insert vraci id noveho, update pocet updatovanych, delete pocet smazanych zaznamu
    @Insert
    suspend fun insert(item: Item): Long

    // anotace @update si sestavi dotaz sama a nahradi zaznam v DB
    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM contacts WHERE id = :id")
    suspend fun getItemById(id: Long): Item

}