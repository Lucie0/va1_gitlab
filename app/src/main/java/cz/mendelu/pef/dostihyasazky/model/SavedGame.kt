package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// ulozena hra
@Entity(tableName = "games")
data class SavedGame(

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "player_on_turn_id")
    var playerOnTurnId: Int
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

    @ColumnInfo(name = "name")
    var name: String? = null

}