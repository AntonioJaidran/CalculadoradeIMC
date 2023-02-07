package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificação = findViewById<TextView>(R.id.textview_Classificação)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*Tabela de Imc
        Menor que 18,5 Abaixo do Peso 0
        Entre 18,5 e 24,9 Normal 0
        Entre 25 e 29,9 Sobrepeso I
        Entre 30 e 39,9 Obesidade II
        Maior que 40,0 Obesidade Grave III */

        val classificacao = if (result < 18.5f) {
            "Abaixo do peso"
        } else if (result in 18.5f..24.9f) {
            "Normal"
        } else if (result in 25f..29.9f) {
            "Sobrepeso"
        } else if (result in 30f..39.9f) {
            "Obesidade"
        } else {
            "Obesidade grave"
        }
        tvClassificação.text = getString(R.string.messageclassificacao,classificacao)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
    }