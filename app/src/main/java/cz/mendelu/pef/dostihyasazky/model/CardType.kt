package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// typy: kun, trener, spacialni karta, servis karta
@Entity(tableName = "card_type")
data class CardType (
    @ColumnInfo(name = "description")
    var text: String
        ){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

}