package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.compose.ui.graphics.Color

@Entity(tableName = "more_details")
data class MoreDetails(
    // k jake karte se vaze
    @ColumnInfo(name = "card_id")
    var cardId: Long,

    //    staj
    @ColumnInfo(name = "stable_type")
    var stableType: String, // todo enum of colors?

    //    prohlidka staje
    @ColumnInfo(name = "stable_visit_cost")
    var stableVisitCost: Int,

    //    dostih zisk
    @ColumnInfo(name = "race_profit")
    var raceProfit: Int,

    //    dostih naklad
    @ColumnInfo(name = "race_cost")
    var raceCost: Int
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

    //    pocet dostihu
    @ColumnInfo(name = "race_count")
    var raceCount: Int = 0

}