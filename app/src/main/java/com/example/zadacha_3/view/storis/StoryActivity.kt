package com.example.zadacha_3.view.storis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.zadacha_3.databinding.ActivityStorisShowBinding
import com.example.zadacha_3.storis.MyAdapter
import com.example.zadacha_3.viewmodel.MyViewModel
import com.genius.multiprogressbar.MultiProgressBar
import kotlin.math.abs

class StoryActivity : AppCompatActivity(), MultiProgressBar.ProgressStepChangeListener,
View.OnClickListener, MultiProgressBar.ProgressFinishListener{
    lateinit var binding: ActivityStorisShowBinding
    lateinit var adapter: MyAdapter
    lateinit var viewPager : ViewPager2
    private var myViewModel = MyViewModel()
    lateinit var multiProgressBar: MultiProgressBar

    private var isDiscreteMode = false
    private var lastStep = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStorisShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storyId = intent.getIntExtra(STORY_ID, lastStep)
        if (storyId == lastStep) {
            throw java.lang.RuntimeException("Story id required!")
        }

        adapter = MyAdapter()
        adapter.submitList(myViewModel.getListById(storyId))
        viewPager = binding.viewPager2
        viewPager.adapter = adapter
        viewPager.currentItem

        binding.right.setOnClickListener(){
            multiProgressBar.next()
        }
        binding.left.setOnClickListener(){
            multiProgressBar.previous()

        }
        binding.viewPager2.setPageTransformer(getTransformation())

        // seekbar
        multiProgressBar= binding.mpbMain

        multiProgressBar.setListener(this)
        multiProgressBar.setProgressStepsCount(myViewModel.getListById(storyId).size)
        multiProgressBar.start()
        multiProgressBar.right

    }




    private fun getTransformation(): CompositePageTransformer {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(30))
        transformer.addTransformer { page, position ->
            page.scaleY = 0.85f + (1 - abs(position)) * 0.15f
            page.setOnClickListener(){

                multiProgressBar.next()
            }

        }
        return transformer
    }

    companion object {
        private const val STORY_ID = "story_id"

        fun getIntent(fromContent: Context, storyId: Int): Intent {
            val intent = Intent(fromContent, StoryActivity::class.java)
            intent.putExtra(STORY_ID, storyId)
            return intent
        }
    }

    override fun onProgressStepChange(newStep: Int) {
        Log.d("STEP", "Current step is $newStep")
        viewPager.currentItem = newStep
    }


    override fun onClick(v: View?) {

    }

    override fun onProgressFinished() {
        Log.d("PROGRESS", "Progress finished")
        this.isDiscreteMode = false
    }

}