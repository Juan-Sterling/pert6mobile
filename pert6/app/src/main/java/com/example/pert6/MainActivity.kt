package com.example.pert6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pert6.adapter.NameDataAdapter
import com.example.pert6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val names = ArrayList<String>()
        names.add("John Doe")
        names.add("Susan Bones")
        names.add("Richard Max")
        names.add("Haha Hihi")

        val nameDataAdapter = NameDataAdapter(names)
        val manager = LinearLayoutManager(this@MainActivity)
        nameDataAdapter.setNameDataListener(object : NameDataAdapter.NameDataListener{
            override fun nameDataClick(name: String) {
                Toast.makeText(this@MainActivity,"Hello $name",Toast.LENGTH_SHORT).show()
            }
        })
        binding.rvdata.adapter = nameDataAdapter
        binding.rvdata.layoutManager = manager
        binding.rvdata.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                manager.orientation
            )
        )
    }
}