package com.wap.storemanagement.ui.todo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.wap.base.BaseFragment
import com.wap.domain.entity.ToDo
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.FragmentTodoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ToDoFragment : BaseFragment<FragmentTodoBinding>(R.layout.fragment_todo) {

    private val toDoAdapter by lazy { ToDoAdapter() }

    private val toDoViewModel by viewModels<ToDoViewModel> { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setCoroutines()
    }

    private fun setAdapter() {
        binding.recyclerViewTodo.adapter = toDoAdapter
    }

    private fun setCoroutines() {
        lifecycleScope.launch {
            collectToDoList()
        }
    }

    private suspend fun collectToDoList() {
        toDoViewModel.toDoList.collect {
            submitToDoItem(it)
        }
    }

    private fun submitToDoItem(toDoList: List<ToDo>) {
        toDoAdapter.submitList(toDoList)
    }
}
