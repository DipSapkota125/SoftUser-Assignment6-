package com.example.softuser.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.softuser.R
import com.example.softuser.model.Student

class StudentAdapter(
        val studentdata:ArrayList<Student>,
        val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    //creating Entity
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgdelete: ImageView

        val imgProfile: ImageView
        val tvfullname: TextView
        val tvage: TextView
        val tvaddress: TextView
        val tvgender: TextView


        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvfullname = view.findViewById(R.id.tvfullname)
            tvage = view.findViewById(R.id.tvage)
            tvaddress = view.findViewById(R.id.tvaddress)
            tvgender = view.findViewById(R.id.tvgender)
            imgdelete=view.findViewById(R.id.imgdelete)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.softuser_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentdata[position]
        holder.tvfullname.text=student.name
        holder.tvage.text=student.age.toString()
        holder.tvaddress.text=student.Address
        holder.tvgender.text=student.gender

        //load image with Glide Library
        Glide.with(context)
                .load(student.image)
                .into(holder.imgProfile)

        holder.imgdelete.setOnClickListener{
            studentdata.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
            notifyItemRangeChanged(position,studentdata.size)
        }
    }

    override fun getItemCount(): Int {
        return studentdata.size
    }

}
