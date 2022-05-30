package com.wap.domain.entity

data class ToDo(
    val toDoId: Long, // 기본키
    val title: String,
    val contents: String,
    val isComplete: Boolean,
) {

    companion object {

        val defaultValue = ToDo(
            toDoId = 1L,
            title = "할 일을 입력해주세요",
            contents = "할 일을 입력해주세요",
            isComplete = false
        )
    }
}
