package com.wap.data.db.dao

import androidx.room.*
import com.wap.data.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dto: TodoEntity)

    @Query("select * from ToDo")
    fun fetchToDoList(): Flow<List<TodoEntity>>

    @Query("select * from ToDo where toDoId = (:toDoId)")
    fun selectOne(toDoId: Long): TodoEntity

    @Update
    suspend fun update(dto: TodoEntity)

    @Delete
    fun delete(dto: TodoEntity)
}
