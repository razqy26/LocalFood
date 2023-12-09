package com.razqy26.localfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFood: RecyclerView
    private var list = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFood = findViewById(R.id.rv_food)
        rvFood.setHasFixedSize(true)

        list.addAll(getListFood())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter
        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentDetail.putExtra("DATA",data)
                startActivity(intentDetail)
            }
        })
    }

    private fun getListFood(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFood = ArrayList<Food>()
        for (i in dataName.indices) {
            val food = Food(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFood.add(food)
        }
        return listFood
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_page -> intentAbout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun intentAbout() {
        intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }


}