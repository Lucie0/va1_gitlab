package cz.mendelu.pef.dostihyasazky.model

import androidx.room.Embedded
import androidx.room.Relation

data class CardWithMoreDetails(
    @Embedded val card: Card,
    @Relation(
        parentColumn = "more_details_id",
        entityColumn = "id"
    )
    val moreDetails: MoreDetails
)