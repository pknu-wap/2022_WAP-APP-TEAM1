package com.wap.storemanagement.ui.todo

import android.os.Bundle
import android.view.View
import com.wap.base.BaseFragment
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.FragmentTodoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoFragment : BaseFragment<FragmentTodoBinding>(R.layout.fragment_todo) {

    private val toDoAdapter by lazy { ToDoAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        binding.recyclerViewTodo.adapter = toDoAdapter
    }
}
