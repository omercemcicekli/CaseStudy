package com.omercemcicekli.casestudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Disable dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.btn_to_automatic_scrolling).setOnClickListener {
            startActivity(Intent(this, AutomaticScrollingActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btn_to_manual_scrolling).setOnClickListener {
            startActivity(Intent(this, ManualScrollingActivity::class.java))
        }
    }
}