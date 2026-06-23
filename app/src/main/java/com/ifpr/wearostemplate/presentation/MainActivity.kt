package com.ifpr.wearostemplate.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.ifpr.wearostemplate.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnIrPerfil = findViewById<View>(R.id.btnIrPerfil)

        btnIrPerfil.setOnClickListener {
            Toast.makeText(this, "Abrindo perfil...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@MainActivity, PerfilActivity::class.java)
            startActivity(intent)
        }
    }
}