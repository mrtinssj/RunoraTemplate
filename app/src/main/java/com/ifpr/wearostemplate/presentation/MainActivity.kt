package com.ifpr.wearostemplate.presentation

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity

import android.widget.Button
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.database.FirebaseDatabase

import com.ifpr.wearostemplate.R
import com.ifpr.wearostemplate.presentation.baseclasses.Corrida
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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

        val btnStop = findViewById<Button>(R.id.btnStop)
        btnStop.setOnClickListener {
            val distanciaKm = 2.5
            val tempoSegundos = 900L
            salvarCorrida(distanciaKm, tempoSegundos)
            Toast.makeText(this, "Corrida salva!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun salvarCorrida(distanciaKm: Double, tempoSegundos:
    Long) {

    }


}

