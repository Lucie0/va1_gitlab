package cz.mendelu.pef.dostihyasazky.database

import cz.mendelu.pef.dostihyasazky.model.Card
import cz.mendelu.pef.dostihyasazky.model.CardWithMoreDetails
import cz.mendelu.pef.dostihyasazky.model.SavedGame
import kotlinx.coroutines.flow.Flow

interface IRacesBetsRepository {
    fun getAllCards(): Flow<List<Card>>

    suspend fun insertCard(item: Card): Long
    suspend fun updateCard(item: Card)
    suspend fun deleteCard(item: Card)

    suspend fun getCardById(id: Long): Card
    fun getCardsByPlayerId(playerId: Long): Flow<List<Card>?>

    fun getCardWithMoreDetails(ownerId: Long): Flow<List<CardWithMoreDetails>?>

    // -----------------------
    fun getAllSavedGames(): Flow<List<SavedGame>?>

    suspend fun insertSavedGame(item: SavedGame): Long
    suspend fun updateSavedGame(item: SavedGame)
    suspend fun deleteSavedGame(item: SavedGame)

    suspend fun getSavedGameById(id: Long): SavedGame
}