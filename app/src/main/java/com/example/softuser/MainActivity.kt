package com.example.softuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.softuser.Fragments.AboutUs
import com.example.softuser.Fragments.AddStudentFragment
import com.example.softuser.Fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private  val homeFragment= HomeFragment()
    private val addStudentFragment = AddStudentFragment()
    private  val aboutUs = AboutUs()
    private lateinit var bottom_navigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation = findViewById(R.id.bottom_navigation)

        replaceFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_home-> replaceFragment(homeFragment)
                R.id.ic_addstudent-> replaceFragment(addStudentFragment)
                R.id.ic_aboutus-> replaceFragment(aboutUs)

            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frafment_container, fragment)
            commit()
        }
    }

}