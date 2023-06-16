package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class Player(
    @ColumnInfo(name = "player_id")
    var playerId: Long? = null
) {
    @ColumnInfo(name = "game_id")
    var gameId: Long? = null

    @ColumnInfo(name = "account")
    var account: Long? = null

    @ColumnInfo(name = "field")
    var field: Long? = null

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_row")
    var idRow: Long? = null
}