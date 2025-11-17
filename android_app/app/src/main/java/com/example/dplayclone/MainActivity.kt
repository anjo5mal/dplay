package com.example.dplayclone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class Channel(val id: Int, val name: String, val logo: String, val stream: String)

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ChannelAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rvChannels)
        val tv = findViewById<TextView>(R.id.tvUser)
        tv.text = "Bem-vindo"
        rv.layoutManager = LinearLayoutManager(this)
        adapter = ChannelAdapter(listOf()) { ch ->
            val i = Intent(this, PlayerActivity::class.java)
            i.putExtra("stream", ch.stream)
            i.putExtra("name", ch.name)
            startActivity(i)
        }
        rv.adapter = adapter

        val api = ApiClient.apiService
        api.getChannels().enqueue(object: Callback<List<Channel>> {
            override fun onResponse(call: Call<List<Channel>>, response: Response<List<Channel>>) {
                if (response.isSuccessful) adapter.update(response.body() ?: listOf())
            }
            override fun onFailure(call: Call<List<Channel>>, t: Throwable) { /* ignore for demo */ }
        })
    }
}
