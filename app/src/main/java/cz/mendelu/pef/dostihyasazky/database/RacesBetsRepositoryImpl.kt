package cz.mendelu.pef.dostihyasazky.database

import cz.mendelu.pef.dostihyasazky.model.Card
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

    override suspend fun getCardByPlayerId(playerId: Long): Card {
        return dao.getCardByPlayerId(playerId)
    }

}