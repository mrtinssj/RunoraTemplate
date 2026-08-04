package com.ifpr.wearostemplate.presentation

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity

import android.widget.Button
import android.widget.ImageButton
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
        btnStop.visibility = View.GONE


        val btnPlay = findViewById<ImageButton>(R.id.btnPlay)
        btnPlay.setOnClickListener {
            if (btnPlay.visibility == View.VISIBLE) {
                btnPlay.visibility = View.GONE
                btnStop.visibility = View.VISIBLE
            } else {
                btnPlay.visibility = View.VISIBLE
                btnStop.visibility = View.GONE
            }
            Toast.makeText(this, "Iniciando corrida...", Toast.LENGTH_SHORT).show()
        }

        btnStop.setOnClickListener {
            val distanciaKm = 2.5
            val tempoSegundos = 900L
            salvarCorrida(distanciaKm, tempoSegundos)

            // Volta para o estado inicial: play visível, stop oculto
            btnStop.visibility = View.GONE
            btnPlay.visibility = View.VISIBLE

            Toast.makeText(this, "Corrida salva!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun salvarCorrida(distanciaKm: Double, tempoSegundos:
    Long) {
        val database = FirebaseDatabase.getInstance()
        val referencia = database.getReference("corridas")
        val id = referencia.push().key ?: return
        val data = SimpleDateFormat("dd/MM/yyyy HH:mm",
            Locale.getDefault()).format(Date())
        val ritmo = calcularRitmo(distanciaKm, tempoSegundos)
        val corrida = Corrida(distanciaKm, tempoSegundos, ritmo, data)
        referencia.child(id).setValue(corrida)
    }

    private fun calcularRitmo(distanciaKm: Double, tempoSegundos:
    Long): String {
        if (distanciaKm <= 0.0) return "0:00"
        val segundosPorKm = (tempoSegundos / distanciaKm).toInt()
        val minutos = segundosPorKm / 60
        val segundos = segundosPorKm % 60
        return "$minutos:"+ segundos.toString().padStart(2, '0')
    }

}

