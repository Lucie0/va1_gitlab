package cz.mendelu.pef.dostihyasazky.model

import androidx.room.DatabaseView
import androidx.room.Embedded
import androidx.room.Relation

@DatabaseView
data class CardWithMoreDetails(
    @Embedded var card: Card,
    @Relation(
        parentColumn = "more_details_id",
        entityColumn = "id_more_details"
    )
    val moreDetails: MoreDetails
){
    override fun toString(): String {
        return card.toString() + ", "+ moreDetails.toString()
    }
}