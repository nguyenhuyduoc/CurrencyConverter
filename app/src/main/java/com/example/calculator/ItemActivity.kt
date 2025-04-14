package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ItemActivity : AppCompatActivity() {
    var items = mutableListOf<ItemModel>()
    lateinit var nameET: EditText
    lateinit var stdIDET: EditText
    lateinit var addBtn: Button
    lateinit var adapter: ItemAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_item_list)

        nameET = findViewById<EditText>(R.id.name)
        stdIDET = findViewById<EditText>(R.id.stdID)
        addBtn = findViewById<Button>(R.id.addButton)
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        repeat(28) {
            items.add(
                ItemModel(
                    "Student $it",
                    "SV$it"
                )
            )
        }

        adapter = ItemAdapter(items)

        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }

    fun addStd(view: View) {
        val name = nameET.text.toString()
        val stdID = stdIDET.text.toString()
        if(name != "" && stdID != "") {
            items.add(0, ItemModel(name, stdID))
            nameET.setText("")
            stdIDET.setText("")
            adapter.notifyItemInserted(0)
            recyclerView.scrollToPosition(0)
        }
    }

}