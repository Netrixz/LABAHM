package com.example.labaoshega

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        calculateButton.setOnClickListener {
            val sideA = sideAEditText.text.toString().toDoubleOrNull()
            val sideB = sideBEditText.text.toString().toDoubleOrNull()
            if (sideA == null || sideB == null) {
                Toast.makeText(this, "Пожалуйста, введите допустимые числа.", Toast.LENGTH_LONG).show()
            } else {
                val hypotenuse = calculateHypotenuse(sideA, sideB)
                Toast.makeText(this, "Гипотенуза: $hypotenuse", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun calculateHypotenuse(a: Double, b: Double): Double {
        return Math.sqrt(a * a + b * b)
    }
}