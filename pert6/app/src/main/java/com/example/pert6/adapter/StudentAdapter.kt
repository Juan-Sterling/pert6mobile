package com.example.pert6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pert6.R
import com.example.pert6.databinding.StudentitemBinding
import com.example.pert6.entity.Student

class StudentAdapter (private val student: ArrayList<Student>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding: StudentitemBinding
        init {
            binding = StudentitemBinding.bind(itemView)
        }
        fun setStudentData(student: Student){
            binding.tvId.text = student.id
            binding.tvName.text = "${student.firstname}${student.lastname}"
            binding.tvDepartment.text = student.department
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.studentitem,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.setStudentData(student[position])
    }

    override fun getItemCount(): Int {
        return student.size
    }
}