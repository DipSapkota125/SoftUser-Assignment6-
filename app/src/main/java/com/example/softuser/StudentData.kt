package com.example.softuser

import com.example.softuser.model.Student
import java.util.ArrayList

class StudentData private constructor() {
    var list = ArrayList<Student>()
    fun List(): ArrayList<Student> {
        return list
    }

    companion object {
        private val data = StudentData()
        fun get(): StudentData {
            return data
        }
    }
}