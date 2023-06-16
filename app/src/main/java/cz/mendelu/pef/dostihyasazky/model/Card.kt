package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// obecna karta
@Entity(tableName = "cards")
data class Card(
    @ColumnInfo(name = "name")
    var name: String,

    // porizovaci cena
    @ColumnInfo(name = "historical_cost")
    var historicalCost: Int,

//    fixni poplatek
    @ColumnInfo(name = "fix_fee")
    var fixFee: Int,

//    typ platby
    @ColumnInfo(name = "payment_type_id")
    var paymentTypeID: Int,

    @ColumnInfo(name = "card_type_id")
    var cardTypeID: Int,

    @ColumnInfo(name = "more_details_id")
    var moreDetailsID: Int? = null,

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_card")
    var id: Long? = null

    //    vlastnik
    @ColumnInfo(name = "owner")
    var ownerNumber: Int? = null

    // image resource
    @ColumnInfo(name = "image")
    var image: Int? = null


//    // ---- trener begin
//    // licence
//    @ColumnInfo(name = "licence")
//    var licenceCost: Int? = null
//    // ---- trener end

    override fun toString(): String {
        return super.toString()
    }
}