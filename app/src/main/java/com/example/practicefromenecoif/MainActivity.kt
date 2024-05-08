package com.example.practicefromenecoif

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicefromenecoif.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit private var bindingClass: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindingClass.bt1.setOnClickListener {
            val resultValue: Int = bindingClass.tx1plain.text.toString().toInt()
            Log.d("MyLog1", "$resultValue")
            when (resultValue) {
                in 0..1000 -> {
                    bindingClass.tx2.visibility = View.VISIBLE
                    bindingClass.tx2.text = "лох"
                }
                in 1000..10000 -> {
                    bindingClass.tx2.visibility = View.VISIBLE
                    bindingClass.tx2.text = "почти не лох"
                }
                in 10000..100000 -> {
                    bindingClass.tx2.visibility = View.VISIBLE
                    bindingClass.tx2.text = "норм"
                }
                else -> {
                    bindingClass.tx2.visibility = View.VISIBLE
                    bindingClass.tx2.text = "ваще норм"
                }
            }

        }
    }
}