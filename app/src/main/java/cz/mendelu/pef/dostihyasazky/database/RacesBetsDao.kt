package cz.mendelu.pef.dostihyasazky.database

import androidx.room.*
import cz.mendelu.pef.dostihyasazky.model.Card
import kotlinx.coroutines.flow.Flow

@Dao
interface RacesBetsDao {
    @Query("SELECT * FROM cards")
    fun getAllCards(): Flow<List<Card>>

    // insert vraci id noveho, update pocet updatovanych, delete pocet smazanych zaznamu
    @Insert
    suspend fun insertCard(item: Card): Long

    // anotace @update si sestavi dotaz sama a nahradi zaznam v DB
    @Update
    suspend fun updateCard(item: Card)

    @Delete
    suspend fun deleteCard(item: Card)

    @Query("SELECT * FROM cards WHERE id = :id")
    suspend fun getCardById(id: Long): Card

    @Query("SELECT * FROM cards WHERE owner = :playerId")
    suspend fun getCardByPlayerId(playerId: Long): Card


}