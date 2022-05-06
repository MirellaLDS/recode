package com.domain.professorallocation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domain.professorallocation.databinding.ItemViewBinding
import kotlin.reflect.KFunction1

class CursoAdapter(
    private val updateCourse: (String) -> Unit,
    private val delete: (String) -> Unit
) : RecyclerView.Adapter<ItemCursoHolder>() {

    private var dataSet = mutableListOf<Curso>()

    fun setData(data: List<Curso>) {
        dataSet.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCursoHolder {
        val holder = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemCursoHolder(holder)
    }

    override fun onBindViewHolder(cursoHolder: ItemCursoHolder, position: Int) {
        cursoHolder.bind(
            dataSet[position],
            actionDelete = delete,
            actionUpdate =  updateCourse
        )
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}