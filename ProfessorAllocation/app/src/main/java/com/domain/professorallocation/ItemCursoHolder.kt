package com.domain.professorallocation

import androidx.recyclerview.widget.RecyclerView
import com.domain.professorallocation.databinding.ItemViewBinding
import kotlin.reflect.KFunction1
import kotlin.reflect.KProperty0

class ItemCursoHolder(private val viewBinding: ItemViewBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(
        curso: Curso,
        actionDelete: (String) -> Unit,
        actionUpdate: (String) -> Unit
    ) {
        viewBinding.tvItemText.text = curso.name

        viewBinding.ivUpdateItem.setOnClickListener { actionUpdate(curso.id) }
    }

}