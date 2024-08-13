package com.imax.cefr.fragments.student.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.imax.cefr.R
import com.imax.cefr.data.models.ExampleData
import com.imax.cefr.data.models.NormalData
import com.imax.cefr.data.models.TextType
import com.imax.cefr.data.models.TitleData
import com.imax.cefr.databinding.ItemExampleBinding
import com.imax.cefr.databinding.ItemNormalBinding
import com.imax.cefr.databinding.ItemTitleBinding

class ExplanationAdapter: RecyclerView.Adapter<ViewHolder>() {

    var models = listOf<ExampleData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun getItemViewType(position: Int): Int {

        return when (models[position].textType) {
            TextType.TITLE -> TextType.TITLE.code
            TextType.NORMAL -> TextType.NORMAL.code
            TextType.EXAMPlE -> TextType.EXAMPlE.code
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TextType.TITLE.code -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_title, parent, false)
                val binding = ItemTitleBinding.bind(view)
                TitleViewHolder(binding)
            }
            TextType.NORMAL.code -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_normal, parent, false)
                val binding = ItemNormalBinding.bind(view)
                NormalViewHolder(binding)
            }
            TextType.EXAMPlE.code -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_example, parent, false)
                val binding = ItemExampleBinding.bind(view)
                ExampleViewHolder(binding)
            }

            else -> {

                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_title, parent, false)
                val binding = ItemTitleBinding.bind(view)
                TitleViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TextType.TITLE.code -> {
                (holder as TitleViewHolder).bind(models[position] as TitleData)
            }
            TextType.NORMAL.code -> {
                (holder as NormalViewHolder).bind(models[position] as NormalData)
            }
            TextType.EXAMPlE.code -> {
                (holder as ExampleViewHolder).bind(models[position] as ExampleData)
            }
        }
    }

    inner class TitleViewHolder(private val binding: ItemTitleBinding): ViewHolder(binding.root) {
        fun bind(titleData: TitleData) {
            binding.tvTitle.text = titleData.body
        }
    }

    inner class NormalViewHolder(private val binding: ItemNormalBinding): ViewHolder(binding.root) {
        fun bind(normalData: NormalData) {
            binding.rvNormal.text = normalData.body
        }
    }

    inner class ExampleViewHolder(private val binding: ItemExampleBinding): ViewHolder(binding.root) {
        fun bind(exampleData: ExampleData) {
            binding.tvExample.text = exampleData.body
        }
    }

}