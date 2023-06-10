package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// karticka kone, specialni karta, servis karta, trener
@Entity
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
    @ColumnInfo(name = "payment_type")
    var paymentType: String, // todo misto Stringu enum?

    @ColumnInfo(name = "card_type")
    var cardType: String, // todo enum

) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    //    vlastnik
    @ColumnInfo(name = "owner")
    var ownerNumber: Int? = null

    // ---- kun begin
    //    staj
    @ColumnInfo(name = "stable_type")
    var stableType: String? = null // todo enum of colors?

    //    pocet dostihu
    @ColumnInfo(name = "race_count")
    var raceCount: Int? = null

    //    prohlidka staje
    @ColumnInfo(name = "stable_visit_cost")
    var stableVisitCost: Int? = null

    //    dostih zisk
    @ColumnInfo(name = "race_profit")
    var raceProfit: Int? = null

    //    dostih naklad
    @ColumnInfo(name = "race_cost")
    var raceCost: Int? = null
    // ---- kun end

    // ---- trener begin
    // licence
    @ColumnInfo(name = "licence")
    var licenceCost: Int? = null
    // ---- trener end

    override fun toString(): String {
        return super.toString()
    }
}