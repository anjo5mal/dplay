package com.example.dplayclone

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.MediaItem

class PlayerActivity : AppCompatActivity() {
    var player: SimpleExoPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        val pv = findViewById<PlayerView>(R.id.player_view)
        val stream = intent.getStringExtra("stream") ?: return
        player = SimpleExoPlayer.Builder(this).build()
        pv.player = player
        val item = MediaItem.fromUri(Uri.parse(stream))
        player?.setMediaItem(item)
        player?.prepare()
        player?.playWhenReady = true
    }
    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }
}
