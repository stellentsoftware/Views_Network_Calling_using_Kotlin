package com.kotlin.demo.ui.activities

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.MediaController
import com.kotlin.demo.R
import kotlinx.android.synthetic.main.activity_video_view.*


class VideoView : AppCompatActivity() {
    private var mediaController: MediaController? = null
    private var TAG = "VideoPlayer"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)
        configureVideoView()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "VideoView"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    //Video from url functionality
    public fun configureVideoView() {

        val video = "https://drive.google.com/uc?authuser=0&id=1sNTxUBkB0X4mtvqflJs32nKZLt6uuq9p&export=download"

// Set the URI to play video file

        mediaController = MediaController(this)
        mediaController?.setAnchorView(videoView)
        mediaController?.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

        videoView.setVideoURI(Uri.parse(video))
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            progressBar.setVisibility(View.GONE);
            Log.i(TAG, "Duration = " + videoView.duration)
        }
        videoView.start()


    }


}
