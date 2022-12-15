package com.android.tp_mickeniepceron.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.tp_mickeniepceron.chuckNorris.model.ChuckNorrisUi
import com.android.tp_mickeniepceron.databinding.ActivityChuckNorrisBinding
import com.android.tp_mickeniepceron.viewmodel.ChuckNorrisViewModel

class ChuckNorrisActivity : AppCompatActivity() {

    private lateinit var viewModel: ChuckNorrisViewModel
    private lateinit var binding : ActivityChuckNorrisBinding
    private val adapter : ChuckNorrisAdapter = ChuckNorrisAdapter()

    private val observer = Observer<List<ChuckNorrisUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChuckNorrisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ChuckNorrisViewModel::class.java]

        binding.chuckNorrisActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.chuckNorrisActivityRv.adapter = adapter

        binding.chuckNorrisActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }

        binding.chuckNorrisActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.chuckNorrisQuoteLiveData.observe(this, observer)
    }

    override fun onStop() {
        viewModel.chuckNorrisQuoteLiveData.removeObserver(observer)
        super.onStop()
    }
}