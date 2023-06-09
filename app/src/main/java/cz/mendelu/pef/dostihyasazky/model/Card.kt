package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// karticka kone
@Entity
data class Card(
    @ColumnInfo(name = "name")
    var name: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}