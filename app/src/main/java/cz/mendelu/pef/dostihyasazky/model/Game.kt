package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// ulozena hra
@Entity(tableName = "games")
data class Game(
    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "player")
    var player: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
}