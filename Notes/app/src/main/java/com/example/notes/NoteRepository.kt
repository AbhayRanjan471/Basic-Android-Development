package com.example.notes

import androidx.lifecycle.LiveData

//CREATE A REPOSITORY

//A repository class abstracts access to multiple data sources.
// A Repository class provides a clean API for data access to the rest of the application.
//the Repository implements the logic for deciding whether to fetch data from a network or use results cached in a local database.

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}