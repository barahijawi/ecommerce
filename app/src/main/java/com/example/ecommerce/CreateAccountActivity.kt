package com.example.ecommerce

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    // Binding object instance with access to the views in the activity_create_account.xml layout
    private lateinit var binding: ActivityCreateAccountBinding

    // Dummy user store for the purpose of the example
    private val registeredUsers = mutableMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAccountButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                if (email in registeredUsers) {
                    Toast.makeText(this, "Account already exists with this email", Toast.LENGTH_SHORT).show()
                } else {
                    // Here you should add proper validation and then add the user to your user store
                    registeredUsers[email] = password
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                    // After account creation, you might want to send the user to the SignInActivity
                    val intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
