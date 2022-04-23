package com.example.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//https://developer.android.com/codelabs/android-room-with-a-view-kotlin#5
//CREATE ENTITY

//to make this class entity we have to Annotate

//Each @Entity class represents a SQLite table. Annotate your class declaration to indicate that it's an entity.
//You can specify the name of the table if you want it to be different from the name of the class
@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name = "text") val text: String) {
    //@ColumnInfo(name = "text") Specifies the name of the column in the table if you want it to be different
    // from the name of the member variable. This names the column "text".
    //@PrimaryKey Every entity needs a primary key. To keep things simple, each word acts as its own primary key.
    @PrimaryKey(autoGenerate = true) var id = 0//this will auto generate an ID
}