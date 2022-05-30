package com.wap.domain.datasource

import com.wap.domain.entity.ToDo
import kotlinx.coroutines.flow.Flow

interface ToDoDataSource {

    fun createToDo(toDo: ToDo)

    fun fetchAllToDoList(): Flow<List<ToDo>>

    fun fetchToDoListById(toDoId: Long): Flow<ToDo>

    fun updateToDo(toDo: ToDo)

    fun deleteToDo(toDo: ToDo)
}