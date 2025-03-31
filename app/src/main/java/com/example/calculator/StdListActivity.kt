package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StdListActivity : AppCompatActivity() {
    var students = mutableListOf<StdModel>()
    lateinit var nameET: EditText
    lateinit var stdIDET: EditText
    lateinit var addBtn: Button
    lateinit var adapter: StdAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_std_list)

        nameET = findViewById<EditText>(R.id.name)
        stdIDET = findViewById<EditText>(R.id.stdID)
        addBtn = findViewById<Button>(R.id.addButton)
        repeat(28) {
            students.add(StdModel(
                "Student $it",
                "SV$it"
            ))
        }

        adapter = StdAdapter(students)

        val listStudents = findViewById<ListView>(R.id.list_students)
        listStudents.adapter = adapter
    }

    fun addStd(view: View) {
        val name = nameET.text.toString()
        val stdID = stdIDET.text.toString()
        if(name != "" && stdID != "") {
            students.add(0, StdModel(name, stdID))
            nameET.setText("")
            stdIDET.setText("")
            adapter.notifyDataSetChanged()
        }
    }

}