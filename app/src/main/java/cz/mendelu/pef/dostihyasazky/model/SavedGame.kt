package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// todo id hracu, kteri obsahuji seznam svych karet, konto a na kterem policku se nachazi
// ulozena hra
@Entity(tableName = "games")
data class SavedGame(

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "player_on_turn_id")
    var playerOnTurnId: Long
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_saved_game")
    var id: Long? = null

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "notes")
    var notes: String? = null

}