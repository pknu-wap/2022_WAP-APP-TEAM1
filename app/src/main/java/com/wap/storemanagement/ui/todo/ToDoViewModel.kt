package com.wap.storemanagement.ui.todo

import com.wap.base.BaseViewModel
import com.wap.base.provider.DispatcherProvider
import com.wap.domain.datasource.ToDoDataSource
import com.wap.domain.entity.ToDo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val toDoDataSource: ToDoDataSource
): BaseViewModel(dispatcherProvider) {

    val toDoList = toDoDataSource.fetchAllToDoList()

    var inputContents = ""

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
