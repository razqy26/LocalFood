package com.razqy26.localfood

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.razqy26.localfood.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Food>("DATA")

        binding.nameFood.text = data?.name
        binding.descFood.text = data?.description
        data?.photo?.let { binding.detailPhoto.setImageResource(it) }

        binding.shareButton.setOnClickListener{
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = data?.description
            val shareSubject = data?.name
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
            startActivity(Intent.createChooser(sharingIntent, "Share using"))
        }

    }

}