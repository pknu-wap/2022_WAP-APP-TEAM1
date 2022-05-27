package com.wap.storemanagement.ui.todo

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.wap.base.BaseViewHolder
import com.wap.domain.entity.ToDo
import com.wap.storemanagement.R
import com.wap.storemanagement.databinding.ItemTodoBinding

class ToDoAdapter : ListAdapter<ToDo, BaseViewHolder<ItemTodoBinding>>(diffUtil){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemTodoBinding> = BaseViewHolder(parent, R.layout.item_todo)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemTodoBinding>, position: Int) {
        holder.binding.item = getItem(position)
    }

    companion object {

        val diffUtil by lazy {
            object : DiffUtil.ItemCallback<ToDo>() {

                override fun areContentsTheSame(oldItem: ToDo, newItem: ToDo) = oldItem == newItem

                override fun areItemsTheSame(oldItem: ToDo, newItem: ToDo) = oldItem.toDoId == newItem.toDoId
            }
        }
    }
}
