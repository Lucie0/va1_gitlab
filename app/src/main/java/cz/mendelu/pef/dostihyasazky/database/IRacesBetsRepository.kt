package cz.mendelu.pef.dostihyasazky.database

import cz.mendelu.pef.dostihyasazky.model.*
import kotlinx.coroutines.flow.Flow

interface IRacesBetsRepository {
    fun getAllCards(): Flow<List<Card>>

    suspend fun insertCard(item: Card): Long
    suspend fun updateCard(item: Card)
    suspend fun deleteCard(item: Card)

    suspend fun getCardById(cardId: Long): Card

    //    fun getCardsByPlayerId(playerId: Long): Flow<List<Card>?>
//
//    fun getCardWithMoreDetailsByOwner(ownerId: Long): Flow<List<CardWithMoreDetails>?>
    suspend fun getCardWithMoreDetailsByCardId(cardId: Long): CardWithMoreDetails?

    suspend fun updateMoreDetails(item: MoreDetails)

    // -----------------------
    fun getAllSavedGames(): Flow<List<SavedGame>?>

    suspend fun insertSavedGame(item: SavedGame): Long
    suspend fun updateSavedGame(item: SavedGame)
    suspend fun deleteSavedGame(item: SavedGame)

    suspend fun getSavedGameById(id: Long): SavedGame

    // --------------------------
    suspend fun insertSavedGameToCard(item: SavedGameToCard): Long
    suspend fun updateSavedGameToCard(item: SavedGameToCard)

    fun getSavedGameToCardWithSavedGameWithCardWMoreDetailsByGameId(gameId: Long): Flow<List<SavedGameToCardWithSavedGameWithCardWMoreDetails>?>
    fun getSavedGameToCardWithSavedGameWithCardWMoreDetailsByOwnerId(ownerId: Long): Flow<List<SavedGameToCardWithSavedGameWithCardWMoreDetails>?>
    fun getSavedGameToCardWithSavedGameWithCardWMoreDetailsByOwnerAndGameId(
        ownerId: Long,
        gameId: Long?
    ): Flow<List<SavedGameToCardWithSavedGameWithCardWMoreDetails>?>

    fun getSavedGameToCardWithSavedGameWithCardWMoreDetailsByOwnerAndNullGameId(ownerId: Long): Flow<List<SavedGameToCardWithSavedGameWithCardWMoreDetails>?>

    //------------------------------
    suspend fun getPlayerByIdAndGameId(playerId: Long, gameId: Long): Player
    suspend fun getPlayerByIdAndNullGameId(playerId: Long): Player
    suspend fun updatePlayer(item: Player)
    suspend fun insertPlayer(item: Player)
}