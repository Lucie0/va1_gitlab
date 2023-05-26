package cz.mendelu.pef.midterm2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class Player(
    @ColumnInfo(name = "name")
    var name: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    @ColumnInfo(name = "on_match")
    var onMatch: Boolean = false

}