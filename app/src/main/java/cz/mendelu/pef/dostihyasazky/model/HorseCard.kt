package cz.mendelu.pef.dostihyasazky.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "horse_card")
data class HorseCard(
    //    staj
    @ColumnInfo(name = "stable_type")
    var stableType: String, // todo enum of colors?

    //    pocet dostihu
    @ColumnInfo(name = "race_count")
    var raceCount: Int,

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

}