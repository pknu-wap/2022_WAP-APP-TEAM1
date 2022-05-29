package com.wap.data.local

import com.wap.data.db.dao.UserDao
import com.wap.data.toEntity
import com.wap.data.toUser
import com.wap.domain.datasource.UserDataSource
import com.wap.domain.entity.User
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val userDao: UserDao
) : UserDataSource {

    override fun getUserById(userId: Long) = userDao.getUserByUserId(userId).toUser()

    override fun createUser(user: User) {
        userDao.insertUser(user.toEntity())
    }

    override fun updateUser(user: User) {
        userDao.updateUser(user.toEntity())
    }

    override fun deleteUser(user: User) {
        userDao.deleteUser(user.toEntity())
    }
}