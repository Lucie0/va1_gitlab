package cz.mendelu.pef.dostihyasazky.database

import cz.mendelu.pef.dostihyasazky.model.Card
import kotlinx.coroutines.flow.Flow

interface IRacesBetsRepository {
    fun getAllCards(): Flow<List<Card>>

    suspend fun insertCard(item: Card): Long
    suspend fun updateCard(item: Card)
    suspend fun deleteCard(item: Card)

    suspend fun getCardById(id: Long): Card
    suspend fun getCardByPlayerId(playerId: Long): Card
}