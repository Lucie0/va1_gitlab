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

    @Query("SELECT * FROM cards WHERE id_card = :id")
    suspend fun getCardById(id: Long): Card

//    @Query("SELECT * FROM cards WHERE owner = :playerId")
//    fun getCardByPlayerId(playerId: Long): Flow<List<Card>?>

//    @Transaction
//    @Query("SELECT * FROM cards WHERE owner = :ownerId")
//    fun getCardWithMoreDetailsByOwner(ownerId: Long): Flow<List<CardWithMoreDetails>?>

    @Transaction
    @Query("SELECT * FROM cards WHERE id_card = :cardId")
    suspend fun getCardWithMoreDetailsByCardId(cardId: Long): CardWithMoreDetails?

    @Update
    suspend fun updateMoreDetails(item: MoreDetails)

    @Query("SELECT * FROM games")
    fun getAllSavedGames(): Flow<List<SavedGame>?>

    @Insert
    suspend fun insertSavedGame(item: SavedGame): Long

    @Update
    suspend fun updateSavedGame(item: SavedGame)

    @Delete
    suspend fun deleteSavedGame(item: SavedGame)

    @Query("SELECT * FROM games WHERE id_saved_game = :id")
    suspend fun getSavedGameById(id: Long): SavedGame

    @Insert
    suspend fun insertSavedGameToCard(item: SavedGameToCard): Long

    @Update
    suspend fun updateSavedGameToCard(item: SavedGameToCard)

    @Transaction
    @Query("SELECT * FROM saved_game_to_card WHERE saved_game_id = :gameId")
    fun getSavedGameToCardWithSavedGameWithCardWMoreDetailsByGameId(
        gameId: Long
    ): Flow<List<SavedGameToCardWithSavedGameWithCardWMoreDetails>?> //

    @Transaction
    @Query("SELECT * FROM saved_game_to_card WHERE player_id = :ownerId")
    fun getSavedGameToCardWithSavedGameWithCardWMoreDetailsByOwnerId(
        ownerId: Long
    ): Flow<List<SavedGameToCardWithSavedGameWithCardWMoreDetails>?>

    @Query("SELECT * FROM saved_game_to_card WHERE player_id = :ownerId AND saved_game_id = :gameId")
    fun getSavedGameToCardWithSavedGameWithCardWMoreDetailsByOwnerAndGameId(
        ownerId: Long, gameId: Long?
    ): Flow<List<SavedGameToCardWithSavedGameWithCardWMoreDetails>?>

    @Query("SELECT * FROM saved_game_to_card WHERE player_id = :ownerId AND saved_game_id IS NULL")
    fun getSavedGameToCardWithSavedGameWithCardWMoreDetailsByOwnerAndNullGameId(ownerId: Long): Flow<List<SavedGameToCardWithSavedGameWithCardWMoreDetails>?>

    @Query("SELECT * FROM players WHERE player_id = :playerId AND game_id = :gameId")
    suspend fun getPlayerByIdAndGameId(playerId: Long, gameId: Long): Player

    @Query("SELECT * FROM players WHERE player_id = :playerId AND game_id IS NULL")
    suspend fun getPlayerByIdAndNullGameId(playerId: Long): Player

    @Update
    suspend fun updatePlayer(item: Player)

    @Insert
    suspend fun insertPlayer(item: Player)

}