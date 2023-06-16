package cz.mendelu.pef.dostihyasazky.database

import androidx.room.*
import androidx.room.Transaction
import cz.mendelu.pef.dostihyasazky.model.*
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
    fun getCardByPlayerId(playerId: Long): Flow<List<Card>?>

    @Transaction
    @Query("SELECT * FROM cards WHERE owner = :ownerId")
    fun getCardWithMoreDetailsByOwner(ownerId: Long): Flow<List<CardWithMoreDetails>?>

    @Transaction
    @Query("SELECT * FROM cards WHERE id = :cardId")
    suspend fun getCardWithMoreDetailsByCardId(cardId: Long): CardWithMoreDetails?

    @Update
    suspend fun updateMoreDetails(item: MoreDetails)

    @Query("SELECT * FROM games")
    fun getAllSavedGames() : Flow<List<SavedGame>?>

    @Insert
    suspend fun insertSavedGame(item: SavedGame): Long

    @Update
    suspend fun updateSavedGame(item: SavedGame)

    @Delete
    suspend fun deleteSavedGame(item: SavedGame)

    @Query("SELECT * FROM games WHERE id = :id")
    suspend fun getSavedGameById(id: Long): SavedGame

    @Insert
    suspend fun insertSavedGameToCard(item: SavedGameToCard): Long

    @Transaction
    @Query("SELECT * FROM games WHERE id = :gameId")
    fun getSavedGameWithSavedGameToCard(gameId: Long): Flow<List<SavedGameWithSavedGameToCard>?>

}