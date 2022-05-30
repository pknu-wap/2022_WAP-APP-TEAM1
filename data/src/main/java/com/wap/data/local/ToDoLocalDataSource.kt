package com.wap.data.local

import com.wap.data.db.dao.TodoDao
import com.wap.data.toEntity
import com.wap.data.toToDo
import com.wap.domain.datasource.ToDoDataSource
import com.wap.domain.entity.ToDo
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ToDoLocalDataSource @Inject constructor(
    private val todoDao: TodoDao
) : ToDoDataSource {

    override suspend fun createToDo(toDo: ToDo) {
        todoDao.createToDo(toDo.toEntity())
    }

    override fun fetchAllToDoList() = todoDao.fetchToDoList().map { entityList -> entityList.toToDo() }

    override fun fetchToDoListById(toDoId: Long) = todoDao.fetchToDoById(toDoId).map { entity -> entity.toToDo() }

    override suspend fun updateToDo(toDo: ToDo) {
        todoDao.updateToDo(toDo.toEntity())
    }

    override suspend fun deleteToDo(toDo: ToDo) {
        todoDao.deleteToDo(toDo.toEntity())
    }
}
