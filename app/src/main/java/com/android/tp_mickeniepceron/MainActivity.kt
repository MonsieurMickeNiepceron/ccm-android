package com.android.tp_mickeniepceron

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.tp_mickeniepceron.databinding.ActivityMainBinding
import com.android.tp_mickeniepceron.view.RecyclerViewActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainButtonRecyclerView.setOnClickListener {
            goToRecyclerView()
        }
    }

    private fun goToRecyclerView() {
        startActivity(Intent(this, RecyclerViewActivity::class.java))
    }
}