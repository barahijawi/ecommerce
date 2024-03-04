package com.example.ecommerce

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInButton.setOnClickListener { attemptLogin() }
    }

    private fun attemptLogin() {
        val username = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        val sharedPref = getSharedPreferences("AppUserPrefs", MODE_PRIVATE)
        val savedPassword = sharedPref.getString(username, null)

        if (password == savedPassword) {
            // Save the logged-in username for later use
            with(sharedPref.edit()) {
                putString("LOGGED_IN_USERNAME", username)
                apply()
            }

            // Successful login
            val intent = Intent(this, ShoppingCategoryActivity::class.java)
            startActivity(intent)
        } else {
            // Error, invalid credentials
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }
}
