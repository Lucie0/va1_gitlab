package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_game_to_card")
data class SavedGameToCard(
    @ColumnInfo(name = "saved_game_id")
    var savedGameId: Int,

    @ColumnInfo(name = "card_id")
    var card_id: Int,

    @ColumnInfo(name = "player_id")
    var playerId: Int
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
}