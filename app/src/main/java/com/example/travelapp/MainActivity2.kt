package com.example.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import com.example.travelapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private var isVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageVisibility.setOnClickListener {
            val currentInputType = binding.editTextPassword.inputType
            binding.editTextPassword.inputType = if (currentInputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            } else {
                InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
            binding.editTextPassword.setSelection(binding.editTextPassword.text.length)
        }
    }
}