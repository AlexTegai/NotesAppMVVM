package ru.alte.notesappmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.alte.notesappmvvm.model.Note
import ru.alte.notesappmvvm.utils.TYPE_FIREBASE
import ru.alte.notesappmvvm.utils.TYPE_ROOM

class MainViewModel(application: Application): AndroidViewModel(application) {

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }

    init {
        readTest.value =
            when(dbType.value) {
                TYPE_ROOM -> {
                    listOf<Note>(
                        Note(title = "Note1", subtitle = "Subtitle for Note1"),
                        Note(title = "Note2", subtitle = "Subtitle for Note2"),
                        Note(title = "Note3", subtitle = "Subtitle for Note3"),
                        Note(title = "Note4", subtitle = "Subtitle for Note4")
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }

    fun initDatabase(type: String) {
        dbType.value = type
        Log.d("MyLog", "MainViewModel with type: $type")
    }
}