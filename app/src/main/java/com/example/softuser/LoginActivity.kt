package com.example.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.softuser.Fragments.HomeFragment
import com.example.softuser.model.LoginValidation

class LoginActivity : AppCompatActivity() {
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: Button

    private  var listlogin = ArrayList<LoginValidation>()

    var username = "softwarica"
    var password = "coventry"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnlogin = findViewById(R.id.btnlogin)
        listlogin = arrayListOf<LoginValidation>()

        btnlogin.setOnClickListener {
            var inputName =etusername.text.toString()
            var inputPassword = etpassword.text.toString()

            val intent = Intent(this,MainActivity::class.java)

            if (inputName.isEmpty() || inputPassword.isEmpty()){
                Toast.makeText(this, "Fields can't be empty", Toast.LENGTH_SHORT).show()
            } else{
                if(inputName.equals(username) && inputPassword.equals(password)){
                    Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                }else{
                    var status = "Log in fail, try again"
                    Toast.makeText(this,status, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}