package com.example.papewall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.papewall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_RetroMVVM_NoActionbar)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(binding.root)

        WallDatabase.getInstance(applicationContext)

    }
}