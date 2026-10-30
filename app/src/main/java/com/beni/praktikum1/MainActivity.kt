package com.beni.praktikum1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etNama)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnForm = findViewById<Button>(R.id.btnForm)
        val btnBrowser = findViewById<Button>(R.id.btnBrowser)

        btnToast.setOnClickListener {
            Toast.makeText(
                this, "Toast button liked " +
                        "Successfully!", Toast.LENGTH_SHORT
            ).show()
        }

        btnForm.setOnClickListener {
            val name = etName.text.toString().trim()

            if (name.isEmpty()) {
                etName.error = "name is required!"
                Toast.makeText(
                    this, "Please fill in your name" +
                            " first!", Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, FormActivity::class.java)
                intent.putExtra("EXTRA_SENDER", name)
                startActivity(intent)

            }
        }

        btnBrowser.setOnClickListener {
            val query = "http://akprind.ac.id"
            val intent = Intent (Intent.ACTION_VIEW, query.toUri(
                ))
            startActivity(intent)
        }
    }
}