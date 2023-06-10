package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @ColumnInfo(name = "event")
    var event: String,

    @ColumnInfo(name = "value")
    var value: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}