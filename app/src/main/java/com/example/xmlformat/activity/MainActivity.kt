package com.example.xmlformat.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlformat.R
import com.example.xmlformat.databinding.ActivityMainBinding
import com.example.xmlformat.model.Student
import com.example.xmlformat.model.XmlParserHandler
import com.example.xmlformat.recyclerview.MyAdapter
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private lateinit var students: ArrayList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        students = arrayListOf()
        try {
            val parser = XmlParserHandler()
            val iStream = assets.open("student_details.xml")
            students = parser.parse(iStream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        recyclerView = binding.recyclerview
        adapter = MyAdapter(students)
        recyclerView.adapter = adapter


    }
}