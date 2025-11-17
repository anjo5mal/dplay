package com.example.dplayclone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btn = findViewById<Button>(R.id.btnLogin)
        val edt = findViewById<EditText>(R.id.edtUser)
        btn.setOnClickListener {
            val user = edt.text.toString().trim()
            if (user.isEmpty()) { Toast.makeText(this, "Digite usuário", Toast.LENGTH_SHORT).show(); return@setOnClickListener }
            val i = Intent(this, MainActivity::class.java)
            i.putExtra("user", user)
            startActivity(i)
            finish()
        }
    }
}
