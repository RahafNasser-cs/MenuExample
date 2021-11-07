package com.example.menuexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.menuexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.setting) {
            val intent = Intent(this, SettingsActivity::class.java)
            this.startActivity(intent)
        } else if (item.itemId == R.id.contact_us) {
            val intent = Intent(this, ContactUsActivity::class.java)
            this.startActivity(intent)
        } else if (item.title == "Login") {
            binding.firstPage.setText("You're clicked on login")
            item.title = "Logout"
        } else {
            binding.firstPage.setText("You're clicked on logout")
            item.title = "Login"
        }
        return true
    }
    private fun goToAnotherActivity(goToActivity: String) {
        val intent = Intent(this, goToActivity::class.java)
        this.startActivity(intent)
    }

}