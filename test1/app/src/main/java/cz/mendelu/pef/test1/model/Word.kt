package cz.mendelu.pef.test1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    @ColumnInfo(name = "cz_word")
    var cz_word: String,
    @ColumnInfo(name = "en_word")
    var en_word: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
}