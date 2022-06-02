package com.wap.data.db.dao

import androidx.room.*
import com.wap.data.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserByUserId(userId: Long): UserEntity

    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

}