package com.wap.domain.datasource

import com.wap.domain.entity.User

interface UserDataSource {

    fun getUserById(userId: Long): User

    fun createUser(user: User)

    fun updateUser(user: User)

    fun deleteUser(user: User)
}
