package cz.mendelu.pef.hw2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @ColumnInfo(name = "fname")
    var fname: String,

    @ColumnInfo(name = "lname")
    var lname: String,

    @ColumnInfo(name = "phone_number")
    var phone_number: String,

    @ColumnInfo(name = "type")
    var type: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

    @ColumnInfo(name = "email")
    var email: String? = null

}