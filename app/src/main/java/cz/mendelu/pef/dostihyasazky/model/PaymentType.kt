package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// typy: dle vlastnictvi, dle balicku, zadna
@Entity(tableName = "payments_type")
data class PaymentType(
    @ColumnInfo(name = "description")
    var text: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

}