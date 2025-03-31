package com.example.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class StdAdapter(val students: MutableList<StdModel>): BaseAdapter() {
    override fun getCount() = students.size

    override fun getItem(p0: Int) = students[p0]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getView(
        p0: Int,
        p1: View?,
        p2: ViewGroup?,
    ): View? {

        val itemView: View
        val viewHolder: ViewHolder

        if (p1 == null) {
            itemView = LayoutInflater.from(p2?.context).inflate(R.layout.layout_std_item, p2, false)
            viewHolder = ViewHolder()
            viewHolder.textHoten = itemView.findViewById<TextView>(R.id.text_hoten)
            viewHolder.textMssv = itemView.findViewById<TextView>(R.id.text_mssv)
            itemView.tag = viewHolder
        } else {
            itemView = p1
            viewHolder = p1.tag as ViewHolder
        }

        val student = students[p0]
        viewHolder.textHoten.text = student.hoten
        viewHolder.textMssv.text = student.mssv

        val clear = itemView.findViewById<ImageView>(R.id.clear)
        clear.setOnClickListener {
            students.removeAt(p0)
            notifyDataSetChanged()
        }

        return itemView
    }

    class ViewHolder {
        lateinit var textHoten: TextView
        lateinit var textMssv: TextView

    }
}