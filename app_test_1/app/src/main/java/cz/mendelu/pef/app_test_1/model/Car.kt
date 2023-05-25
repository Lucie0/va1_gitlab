package cz.mendelu.pef.app_test_1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "cars")
data class Car(
    @ColumnInfo(name = "spz")
    var spz: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

}