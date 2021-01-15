package com.example.softuser.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softuser.Adapter.StudentAdapter
import com.example.softuser.R
import com.example.softuser.StudentData
import com.example.softuser.model.Student


class HomeFragment : Fragment() {
    private lateinit var recylerview: RecyclerView
    //private lateinit var btnrefresh: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recylerview = view.findViewById(R.id.recylerview)
        //btnrefresh = view.findViewById(R.id.btnrefresh)


//        btnrefresh.setOnClickListener {
//            recylerview.adapter?.notifyDataSetChanged()
//
//        }

        if(StudentData.get().List().size==0){
            loadStudents();
        }

        val adapter=StudentAdapter(StudentData.get().List(),context!!)
        recylerview.layoutManager= LinearLayoutManager(context)
        recylerview.adapter=adapter

        return view;
    }

    private fun loadStudents() {
        StudentData.get().List().add(
            Student(1,"Dip Sapkota",21,"Male","Dillibazar",
            "https://scontent.fktm7-1.fna.fbcdn.net/v/t1.0-9/125542512_1037175063464375_5108204506547963151_n.jpg?_nc_cat=103&ccb=2&_nc_sid=09cbfe&_nc_ohc=dhzJftr6rSQAX-TNGLU&_nc_ht=scontent.fktm7-1.fna&oh=b97d346b4dcddbf33833d19754b3ed92&oe=6027EB57")
        )

        StudentData.get().List().add(
            Student(2,"Ranjit Sapkota",20,"Male","Maitidevi",
                "https://scontent.fktm7-1.fna.fbcdn.net/v/t1.0-9/108017236_933882180460331_2322510044548948057_n.jpg?_nc_cat=105&ccb=2&_nc_sid=a4a2d7&_nc_ohc=B758avF-LY0AX8NEeo7&_nc_ht=scontent.fktm7-1.fna&oh=49ada2f8d266e581632adcd86e16e526&oe=6026E819")
        )

        StudentData.get().List().add(
            Student(3,"Saddicha shrestha",29,"Female","Darbarmarg",
                "https://bestcelebspicture.files.wordpress.com/2011/08/sadichha_in_newari_dress.jpg")
        )
    }


}