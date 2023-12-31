package com.example.papewall.repository

import com.example.papewall.database.localData.dao.WallDatabase
import com.example.papewall.database.localData.data.LocalWall
import io.reactivex.rxjava3.core.Completable

class WallRepositery {
     val dao = WallDatabase.getInstanceWithoutContext().wallDao()
     fun insertNewNote(note: LocalWall): Completable {
        return dao.insert(note)
    }

    fun getAllNotes() = dao.getAllNote()
}