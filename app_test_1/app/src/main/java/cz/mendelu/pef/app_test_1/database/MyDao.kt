package cz.mendelu.pef.app_test_1.database

import androidx.room.*
import cz.mendelu.pef.app_test_1.model.Car as Item
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Query("SELECT * FROM cars")
    fun getAll(): Flow<List<Item>>

    // insert vraci id noveho, update pocet updatovanych, delete pocet smazanych zaznamu
    @Insert
    suspend fun insert(item: Item): Long

    // anotace @update si sestavi dotaz sama a nahradi zaznam v DB
    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM cars WHERE id = :id")
    suspend fun getItemById(id: Long): Item

}