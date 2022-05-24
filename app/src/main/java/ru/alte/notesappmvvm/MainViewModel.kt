package ru.alte.notesappmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.alte.notesappmvvm.database.room.AppRoomDatabase
import ru.alte.notesappmvvm.database.room.repository.RoomRepository
import ru.alte.notesappmvvm.model.Note
import ru.alte.notesappmvvm.utils.REPOSITORY
import ru.alte.notesappmvvm.utils.TYPE_FIREBASE
import ru.alte.notesappmvvm.utils.TYPE_ROOM

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application

    fun initDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("MyLog", "MainViewModel with type: $type")
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }
}