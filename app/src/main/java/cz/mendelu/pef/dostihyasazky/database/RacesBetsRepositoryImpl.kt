package cz.mendelu.pef.dostihyasazky.database

import cz.mendelu.pef.dostihyasazky.model.Card
import cz.mendelu.pef.dostihyasazky.model.CardWithMoreDetails
import cz.mendelu.pef.dostihyasazky.model.SavedGame
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

    override fun getCardWithMoreDetails(ownerId: Long): Flow<List<CardWithMoreDetails>?> {
        return dao.getCardWithMoreDetails(ownerId)
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

}