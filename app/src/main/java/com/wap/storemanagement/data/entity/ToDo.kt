package com.wap.storemanagement.data.entity

data class ToDo(
    val toDoId: Long, // 기본키
    val title: String,
    val contents: String,
    val isComplete: Boolean,
)