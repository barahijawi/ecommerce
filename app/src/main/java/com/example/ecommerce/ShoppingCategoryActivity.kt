package com.example.ecommerce

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.databinding.ActivityShoppingCategoryBinding

class ShoppingCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the logged-in username
        val sharedPref = getSharedPreferences("AppUserPrefs", MODE_PRIVATE)
        val loggedInUsername = sharedPref.getString("USERNAME", "User")
        binding.welcomeTextView.text = "Welcome, $loggedInUsername"

        // Setup listeners for your category buttons
        binding.linearLayoutHomeKitchen.setOnClickListener { showToast("Home & Kitchen") }
        binding.linearLayoutBeautyCare.setOnClickListener { showToast("Beauty & Personal Care") }
        binding.linearLayoutPetSupplies.setOnClickListener { showToast("Pet Supplies") }
        binding.linearLayoutToysGames.setOnClickListener { showToast("Toys & Games") }

    }

    private fun showToast(category: String) {
        Toast.makeText(this, "Selected Category: $category", Toast.LENGTH_SHORT).show()
    }
}
