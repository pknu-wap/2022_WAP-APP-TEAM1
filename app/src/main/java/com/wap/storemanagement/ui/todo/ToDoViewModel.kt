package com.wap.storemanagement.ui.todo

import androidx.lifecycle.viewModelScope
import com.wap.base.BaseViewModel
import com.wap.base.provider.DispatcherProvider
import com.wap.data.db.dao.TodoDao
import com.wap.data.toToDo
import com.wap.domain.entity.ToDo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val todoDao: TodoDao
): BaseViewModel(dispatcherProvider) {

    val toDoList: StateFlow<List<ToDo>> = todoDao.fetchToDoList()
        .map { todoEntityList -> todoEntityList.map { entity -> entity.toToDo() } }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
}
