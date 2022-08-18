package com.example.testapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapi.adapter.MyMovieAdapter
import com.example.testapi.common.Common
import com.example.testapi.model.Movie
import com.example.testapi.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitServices
        recyclerView = findViewById(R.id.recyclerMovieList)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        getAllMovieList()
    }

    private fun getAllMovieList() {
        //dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>>{
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                adapter = MyMovieAdapter(baseContext,response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            }
        })
    }
}