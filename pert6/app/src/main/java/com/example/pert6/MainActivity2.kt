package com.example.pert6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pert6.adapter.StudentAdapter
import com.example.pert6.databinding.ActivityMain2Binding
import com.example.pert6.entity.Student
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var students: ArrayList<Student>
    private lateinit var studentAdapter: StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        students = ArrayList()
        val studentAdapter = StudentAdapter(students)
        val manager = LinearLayoutManager(this@MainActivity2)

        binding.rvstudent.adapter = studentAdapter
        binding.rvstudent.layoutManager = manager
    }

    override fun onStart() {
        super.onStart()
        fetchStudentData()
    }
    private fun fetchStudentData(){
        val inputStream = assets.open("students.json")
        val reader = JsonReader(InputStreamReader(inputStream,"UTF-8"))
        val gson = Gson()
        val data = gson.fromJson<Array<Student>>(reader,Array<Student>::class.java)
        students.clear()
        students.addAll(data)
        studentAdapter.notifyItemChanged(0)
    }
}