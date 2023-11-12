package com.ifam.hotelll

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIrParaSegundaActivity: Button = findViewById(R.id.buttonLogin)

        btnIrParaSegundaActivity.setOnClickListener {
            // Crie um Intent para iniciar a SegundaActivity
            val intent = Intent(this@MainActivity, TelaPrincipal::class.java)

            // Inicie a SegundaActivity
            startActivity(intent)
        }
    }
}