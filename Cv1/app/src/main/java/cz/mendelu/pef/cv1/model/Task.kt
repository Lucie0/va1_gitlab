package cz.mendelu.pef.cv1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks") // vytvoreni tabulky v db
data class Task(
    @ColumnInfo(name = "text") // rikam, ze tento parametr je sloupec a jmenuje se text
    val text: String
    ){ // datova trida, vyzaduje jednu hodnotu

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null // muze byt null kvuli tomu, aby se poznalo, ze je to budto novy zaznam, nebo upravovani stavajiciho

}
