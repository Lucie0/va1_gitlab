package cz.mendelu.pef.dostihyasazky.database

import cz.mendelu.pef.dostihyasazky.model.*
import kotlinx.coroutines.flow.Flow

class RacesBetsRepositoryImpl(private val dao: RacesBetsDao) : IRacesBetsRepository {
    override fun getAllCards(): Flow<List<Card>> {
        return dao.getAllCards()
    }

    override suspend fun insertCard(item: Card): Long {
        return dao.insertCard(item)
    }

    override suspend fun updateCard(item: Card) {
        return dao.updateCard(item)
    }

    override suspend fun deleteCard(item: Card) {
        return dao.deleteCard(item)
    }

    override suspend fun getCardById(id: Long): Card {
        return dao.getCardById(id)
    }

    override fun getCardsByPlayerId(playerId: Long): Flow<List<Card>?> {
        return dao.getCardByPlayerId(playerId)
    }

    override fun getCardWithMoreDetailsByOwner(ownerId: Long): Flow<List<CardWithMoreDetails>?> {
        return dao.getCardWithMoreDetailsByOwner(ownerId)
    }

    override suspend fun getCardWithMoreDetailsByCardId(cardId: Long): CardWithMoreDetails? {
        return dao.getCardWithMoreDetailsByCardId(cardId)
    }

    override suspend fun updateMoreDetails(item: MoreDetails) {
        return dao.updateMoreDetails(item)
    }

    // ---------------------
    override fun getAllSavedGames(): Flow<List<SavedGame>?> {
        return dao.getAllSavedGames()
    }

    override suspend fun insertSavedGame(item: SavedGame): Long {
        return dao.insertSavedGame(item)
    }

    override suspend fun updateSavedGame(item: SavedGame) {
        return dao.updateSavedGame(item)
    }

    override suspend fun deleteSavedGame(item: SavedGame) {
        return dao.deleteSavedGame(item)
    }

    override suspend fun getSavedGameById(id: Long): SavedGame {
        return dao.getSavedGameById(id)
    }

    override suspend fun insertSavedGameToCard(item: SavedGameToCard): Long {
        return dao.insertSavedGameToCard(item)
    }

    override fun getSavedGameWithSavedGameToCard(gameId: Long): Flow<List<SavedGameWithSavedGameToCard>?> {
        return dao.getSavedGameWithSavedGameToCard(gameId)
    }

}