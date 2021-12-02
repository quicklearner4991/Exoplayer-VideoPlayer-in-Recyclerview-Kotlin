package com.example.exoplayer

import androidx.appcompat.app.AppCompatActivity
import com.example.exoplayer.utils.ExoPlayerRecyclerView
import com.example.exoplayer.model.MediaObject
import com.example.exoplayer.adapter.MediaRecyclerAdapter
import android.os.Bundle
import com.example.exoplayer.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var mRecyclerView: ExoPlayerRecyclerView? = null
    private val mediaObjectList = ArrayList<MediaObject>()
    private var mAdapter: MediaRecyclerAdapter? = null
    private val firstTime = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        // Prepare demo content
        prepareVideoList()

        //set data object
        mRecyclerView!!.setMediaObjects(mediaObjectList)
        mAdapter = MediaRecyclerAdapter(mediaObjectList, initGlide())

        //Set Adapter
        mRecyclerView!!.adapter = mAdapter
        mRecyclerView!!.smoothScrollToPosition(1)
        //mRecyclerView.smoothScrollToPosition(1);
        /*   if (firstTime) {
      new Handler(Looper.getMainLooper()).post(new Runnable() {
        @Override
        public void run() {
          mRecyclerView.playVideo(false);
        }
      });
      firstTime = false;
    }*/
    }

    private fun initView() {
        mRecyclerView = findViewById(R.id.exoPlayerRecyclerView)
        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this))
    }

    private fun initGlide(): RequestManager {
        val options = RequestOptions()
        return Glide.with(this)
            .setDefaultRequestOptions(options)
    }

    override fun onDestroy() {
        if (mRecyclerView != null) {
            mRecyclerView!!.releasePlayer()
        }
        super.onDestroy()
    }

    private fun prepareVideoList() {
        val mediaObject = MediaObject()
        mediaObject.id = 1
        mediaObject.userHandle = "User 1"
        mediaObject.title = "Item 1"
        mediaObject.coverUrl =
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1"
        mediaObject.url =
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4"
        val mediaObject2 = MediaObject()
        mediaObject2.id = 2
        mediaObject2.userHandle = "user 2"
        mediaObject2.title = "Item 2"
        mediaObject2.coverUrl =
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1"
        mediaObject2.url =
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4"
        val mediaObject3 = MediaObject()
        mediaObject3.id = 3
        mediaObject3.userHandle = "User 3"
        mediaObject3.title = "Item 3"
        mediaObject3.coverUrl =
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1"
        mediaObject3.url =
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4"
        val mediaObject4 = MediaObject()
        mediaObject4.id = 4
        mediaObject4.userHandle = "User 4"
        mediaObject4.title = "Item 4"
        mediaObject4.coverUrl =
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1"
        mediaObject4.url =
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4"
        val mediaObject5 = MediaObject()
        mediaObject5.id = 5
        mediaObject5.userHandle = "User 5"
        mediaObject5.title = "Item 5"
        mediaObject5.coverUrl =
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1"
        mediaObject5.url =
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4"
        mediaObjectList.add(mediaObject)
        mediaObjectList.add(mediaObject2)
        mediaObjectList.add(mediaObject3)
        mediaObjectList.add(mediaObject4)
        mediaObjectList.add(mediaObject5)
    }
}