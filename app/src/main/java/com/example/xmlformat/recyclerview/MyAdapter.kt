package com.example.xmlformat.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlformat.databinding.CellBinding
import com.example.xmlformat.model.Student

class MyAdapter(private val students: ArrayList<Student>): RecyclerView.Adapter<MyAdapter.MyHolder>() {

    class MyHolder(val binding: CellBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyHolder {
        return MyHolder(
            CellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyAdapter.MyHolder, position: Int) {
        val student = students[position]
        holder.binding.apply {
            studentNameTv.text = student.name
            studentGradeTv.text = student.grade
        }
    }

    override fun getItemCount(): Int = students.size
}