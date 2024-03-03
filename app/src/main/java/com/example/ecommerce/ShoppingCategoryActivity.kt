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

        // Setup listeners for your category buttons
        // Assuming buttons are named in your layout file
        binding.homeKitchenButton.setOnClickListener { showToast("Home & Kitchen") }
        binding.beautyCareButton.setOnClickListener { showToast("Beauty & Personal Care") }
        binding.petSuppliesButton.setOnClickListener { showToast("Pet Supplies") }
        binding.toysGamesButton.setOnClickListener { showToast("Toys & Games") }
    }

    private fun showToast(category: String) {
        Toast.makeText(this, "Selected Category: $category", Toast.LENGTH_SHORT).show()
    }
}
