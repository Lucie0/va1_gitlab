package cz.pef.mendelu.exam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faults")
data class Fault(
    @ColumnInfo(name = "reason")
    var text: String,

    @ColumnInfo(name = "points")
    var points: Int? = null,

    @ColumnInfo(name = "date")
    var date: Long? = null

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null


}