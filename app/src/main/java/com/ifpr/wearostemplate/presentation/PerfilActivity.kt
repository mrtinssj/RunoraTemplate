package com.ifpr.wearostemplate.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.ifpr.wearostemplate.R

class PerfilActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(this, "Perfil abriu", Toast.LENGTH_SHORT).show()

        setContentView(R.layout.activity_perfil)
    }
}