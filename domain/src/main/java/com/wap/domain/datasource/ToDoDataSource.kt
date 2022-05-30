package com.wap.domain.datasource

import com.wap.domain.entity.ToDo

interface ToDoDataSource {

    fun createToDo(toDo: ToDo)

    fun fetchAllToDoList(): List<ToDo>

    fun fetchToDoListById(toDoId: Long): ToDo

    fun updateToDo(toDo: ToDo)

    fun deleteToDo(toDo: ToDo)
}