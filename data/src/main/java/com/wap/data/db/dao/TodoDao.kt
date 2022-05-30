package com.wap.data.db.dao

import androidx.room.*
import com.wap.data.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createToDo(dto: TodoEntity)

    @Query("select * from ToDo")
    fun fetchToDoList(): Flow<List<TodoEntity>>

    @Query("select * from ToDo where toDoId = (:toDoId)")
    fun fetchToDoById(toDoId: Long): Flow<TodoEntity>

    @Update
    suspend fun updateToDo(dto: TodoEntity)

    @Delete
    fun deleteToDo(dto: TodoEntity)
}
