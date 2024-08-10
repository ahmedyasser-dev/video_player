package com.ahmedyasser.video_player

import android.net.Uri
import android.net.Uri.parse
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.widget.MediaController
import android.widget.VideoView
import com.ahmedyasser.video_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //refer to the videoView in the xml file
        val videoView = findViewById<VideoView>(binding.testVideoView.id)

        //creating a media controller
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //specify the location of the media file
        val uri:Uri = parse("android.resource://$packageName/raw/sneakers_shop")

        //setting mediaController and URI
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}