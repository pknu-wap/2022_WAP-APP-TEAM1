package com.wap.data.db.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.wap.data.db.AppDatabase
import com.wap.data.entity.UserEntity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserDaoTest {

    private lateinit var db: AppDatabase

    private lateinit var userDao: UserDao

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        userDao = db.UserDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun when_getUserId_then_success() {
        // Given insert user
        val user = UserEntity(1L, "aa")
        userDao.insertUser(user)

        // Then equal two user
        assertEquals(user, userDao.getUserByUserId(1L))
    }

    @Test
    fun when_updateUser_then_success() {
        // Given insert user
        val user = UserEntity(1L, "aa")
        userDao.insertUser(user)

        // When update user
        val newUser = user.copy(name = "bb")
        userDao.updateUser(newUser)

        // Then newUser in db
        assertEquals(newUser, userDao.getUserByUserId(1L))
    }
}