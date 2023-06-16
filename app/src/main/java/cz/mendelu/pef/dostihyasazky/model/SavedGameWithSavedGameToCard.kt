package cz.mendelu.pef.dostihyasazky.model

import androidx.room.Embedded
import androidx.room.Relation

data class SavedGameWithSavedGameToCard(
    @Embedded val savedGame: SavedGame,
    @Relation(
        parentColumn = "id",
        entityColumn = "saved_game_id"
    )
    val savedGameToCard: SavedGameToCard
)