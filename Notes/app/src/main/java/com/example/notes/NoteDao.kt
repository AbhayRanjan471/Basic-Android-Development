package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

//CREATE THE DAO

//NoteDao is an interface; DAOs must either be interfaces or abstract classes.
//The @Dao annotation identifies it as a DAO class for Room.
@Dao
interface NoteDao {

    //The @Insert annotation is a special DAO method annotation where you don't have to provide any SQL!
    // (There are also @Delete and @Update annotations for deleting and updating rows

    //onConflict = OnConflictStrategy.IGNORE: The selected onConflict strategy ignores a new word
    // if it's exactly the same as one already in the list.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(note: Note) //this function will take a note and insert in the table
   //hum suspend isliye us kr rahe hai taki ye jo kam hai humara backgroud me ho na ki main thread me , isse ye
   //ho ga ki humhara app lagg nai kre ga jb v hum insert ya delete kre ge
   // [suspend are basically coroutines] : coroutine ke help se hum background ki kam ko bout easly kr skte hair

    @Delete
    suspend fun delete(note: Note)//this will take a note and delete it

    //Query that returns a list of words sorted in ascending order.
    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>  //A method to get all the note and have it return a List of Note.
    //agar hum chahte hai ki humhare table le andar jo v changes ho rahe hai wo hume pata chalna chahiye
    //(humhare activity ko pata chalna chahiye) to hum ise [ LiveData<> banana ho ga ]
}