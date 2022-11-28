package com.m9.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSignIn: Button = findViewById(R.id.btnSignIn);
        var txtUsername: EditText = findViewById(R.id.txtUsername);
        var txtPassword: EditText = findViewById(R.id.txtPassword);
        btnSignIn.setOnClickListener {
            if(txtUsername.getText().toString() == "Harun" && txtPassword.getText().toString()=="Harun"){
                val intent = Intent(this, BottomNav::class.java)
                startActivity(intent)

            }else{
                Log.i("testHarun", "login incorrecto")
            }


        }
    }
}
