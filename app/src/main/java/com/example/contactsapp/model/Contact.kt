package com.example.contactsapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @ColumnInfo(name = "fname")
    var fname: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

    @ColumnInfo(name = "lname")
    var lname: String? = null

    @ColumnInfo(name = "phone_number")
    var phone_number: String? = null

    @ColumnInfo(name = "type")
    var type: String? = null

    @ColumnInfo(name = "email")
    var email: String? = null

}