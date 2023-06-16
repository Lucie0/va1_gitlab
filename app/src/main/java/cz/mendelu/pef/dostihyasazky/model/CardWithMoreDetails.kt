package cz.mendelu.pef.dostihyasazky.model

import androidx.room.DatabaseView
import androidx.room.Embedded
import androidx.room.Relation

@DatabaseView
data class CardWithMoreDetails(
    @Embedded val card: Card,
    @Relation(
        parentColumn = "more_details_id",
        entityColumn = "id_more_details"
    )
    val moreDetails: MoreDetails
)