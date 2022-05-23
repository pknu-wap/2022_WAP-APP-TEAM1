package com.wap.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wap.domain.entity.ToDo

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dto: ToDo)

    @Query("select * from ToDo")
    fun list(): LiveData<MutableList<ToDo>>

    @Query("select * from ToDo where toDoId = (:toDoId)")
    fun selectOne(toDoId: Long): ToDo

    @Update
    suspend fun update(dto: ToDo)

    @Delete
    fun delete(dto: ToDo)
}
