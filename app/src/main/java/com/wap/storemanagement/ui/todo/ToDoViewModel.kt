package com.wap.storemanagement.ui.todo

import androidx.lifecycle.viewModelScope
import com.wap.base.BaseViewModel
import com.wap.base.provider.DispatcherProvider
import com.wap.domain.datasource.ToDoDataSource
import com.wap.domain.entity.ToDo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val toDoDataSource: ToDoDataSource
): BaseViewModel(dispatcherProvider) {

    private var _toDoList: StateFlow<List<ToDo>> = flowOf(listOf(ToDo.defaultValue))
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    val toDoList: StateFlow<List<ToDo>> = _toDoList

    var inputContents = ""

    init {
        fetchAllToDoList()
    }

    fun fetchAllToDoList() = onIo {
        _toDoList = toDoDataSource.fetchAllToDoList()
            .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
    }

    fun createToDo() = onIo {
        toDoDataSource.createToDo(
            ToDo(
                toDoId = 1L,
                title = inputContents,
                contents = inputContents,
                isComplete = false
            )
        )
    }
}
