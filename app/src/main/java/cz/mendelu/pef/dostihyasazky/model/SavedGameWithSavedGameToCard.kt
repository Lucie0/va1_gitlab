package cz.mendelu.pef.dostihyasazky.model

import androidx.room.Embedded
import androidx.room.Relation

data class SavedGameToCardWithSavedGameWithCardWMoreDetails(
    @Embedded val savedGameToCard: SavedGameToCard,
    @Relation(
        parentColumn = "saved_game_id",
        entityColumn = "id_saved_game"
    )
    val savedGame: SavedGame?,

    @Relation(
        parentColumn = "card_id",
        entityColumn = "id_card"
    )
    val card: Card,
    @Relation(
        parentColumn = "more_details_id",
        entityColumn = "id_more_details"
    )
    val moreDetails: MoreDetails
)