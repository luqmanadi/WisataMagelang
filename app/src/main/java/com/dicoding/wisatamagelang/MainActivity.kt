package com.dicoding.wisatamagelang

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.wisatamagelang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvWisata: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvWisata = binding.rvWisataMagelang
        rvWisata.setHasFixedSize(true)

        list.addAll(getListWisata())
        showRecylerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main,menu)
        super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_profile->{
                val intentProfile = Intent(this@MainActivity,Profile::class.java)
                startActivity(intentProfile)
                return true
            }
            else-> return super.onOptionsItemSelected(item)

       }

    }

    private fun getListWisata(): ArrayList<Wisata>{
        val dataNamaWisata = resources.getStringArray(R.array.data_name_wisata)
        val dataDescriptionWisata = resources.getStringArray(R.array.data_description_wisata)
        val dataPhotoWisata = resources.obtainTypedArray(R.array.data_photo_wisata)
        val dataHargaWisata = resources.getStringArray(R.array.harga_tiket)
        val dataJadwalWisata = resources.getStringArray(R.array.jam_buka)
        val dataAlamatWisata = resources.getStringArray(R.array.alamat_wisata)
        val dataGoogleWisata = resources.getStringArray(R.array.alamat_google)
        val listWisata = ArrayList<Wisata>()
        for (i in dataNamaWisata.indices){
            val wisata = Wisata(
                dataNamaWisata[i],
                dataDescriptionWisata[i],
                dataPhotoWisata.getResourceId(i,-1),
                dataHargaWisata[i],
                dataJadwalWisata[i],
                dataAlamatWisata[i],
                dataGoogleWisata[i])
            listWisata.add(wisata)
        }
        return listWisata
    }

    private fun showRecylerList(){
        rvWisata.layoutManager = LinearLayoutManager(this)
        val listWisataAdapter = ListAdapterWisata(list)
        rvWisata.adapter = listWisataAdapter
    }
}