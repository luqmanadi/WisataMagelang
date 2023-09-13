package com.dicoding.wisatamagelang

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailWisata : AppCompatActivity() {

    companion object{
        const val EXTRA_WISATA = "extra_wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        val wisataDetail = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Wisata>(EXTRA_WISATA,Wisata::class.java)
        }   else   {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Wisata>(EXTRA_WISATA)
        }

        val tvName = findViewById<TextView>(R.id.tv_nama_detail)
        val tvDescription = findViewById<TextView>(R.id.tv_desktipsi)
        val tvPhoto = findViewById<ImageView>(R.id.image_wisata)
        val tvTiket = findViewById<TextView>(R.id.tv_tiket)
        val tvJamBuka = findViewById<TextView>(R.id.tv_jambuka)
        val tvAlamat = findViewById<TextView>(R.id.tv_alamat)
        val btnGoogleMaps = findViewById<Button>(R.id.btn_buka_maps)
        btnGoogleMaps.setOnClickListener{
            val link = Uri.parse(wisataDetail?.googleAddress)
            val goToMaps = Intent(Intent.ACTION_VIEW,link)
            goToMaps.setPackage("com.google.android.apps.maps")
            startActivity(goToMaps)
        }

        if (wisataDetail != null) {
            tvName.text = wisataDetail.name
            tvDescription.text = wisataDetail.description
            tvPhoto.setImageResource(wisataDetail?.photo!!)
            tvTiket.text = wisataDetail.ticket
            tvJamBuka.text = wisataDetail.schedule
            tvAlamat.text = wisataDetail.address
        }
    }

}