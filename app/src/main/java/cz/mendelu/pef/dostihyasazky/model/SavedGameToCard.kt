package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_game_to_card")
data class SavedGameToCard(
    @ColumnInfo(name = "saved_game_id")
    var savedGameId: Long? = null,

    @ColumnInfo(name = "card_id")
    var cardId: Long,

    @ColumnInfo(name = "player_id")
    var playerId: Long? = null,

    @ColumnInfo(name = "more_details_id")
    var moreDetailsId: Long
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
}