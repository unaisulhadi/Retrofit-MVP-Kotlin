package com.hadi.retrofitmvp.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.hadi.retrofitmvp.databinding.ActivityMainBinding
import com.hadi.retrofitmvp.model.PicsResponse
import com.hadi.retrofitmvp.presenter.PicturesPresenter
import com.hadi.retrofitmvp.presenter.PicturesView
import com.hadi.retrofitmvp.view.adapter.PicsAdapter

class MainActivity : AppCompatActivity(), PicturesView {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {

        val presenter = PicturesPresenter(this)
        presenter.getPictures()

    }

    override fun onLoadedPictures(pics: PicsResponse) {

        // API Request Success, setup adapter
        val adapter = PicsAdapter(this)
        adapter.setList(pics)

        binding.rvPics.setHasFixedSize(true)
        binding.rvPics.layoutManager = GridLayoutManager(this,2)
        binding.rvPics.adapter = adapter

    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        binding.progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progress.visibility = View.GONE
    }
}