package com.example.myquizapp

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_level.*


class LevelFragment : Fragment() {

    lateinit var prefs: SharedPreferencesHelper
    var mediumGreyBackground: Boolean = false
    var hardGreyBackground: Boolean = false
    var state: LevelQuiz? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefs = SharedPreferencesHelper(requireContext())

        return inflater.inflate(R.layout.fragment_level, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        defaultShape()
        var level = LevelQuiz.EASY

        state = prefs.getState()

        levelShape()




        easy_level.setOnClickListener {
            //findNavController().navigate(R.id.action_levelFragment_to_quizFragment)
            level = LevelQuiz.EASY
            prefs.setCurrentLevelQuiz(level)
            val action = LevelFragmentDirections.actionLevelFragmentToQuizFragment(level)
            findNavController().navigate(action)
        }

        if (!mediumGreyBackground) {
            medium_level.setOnClickListener {
                level = LevelQuiz.NORMAL
                prefs.setCurrentLevelQuiz(level)
                val action = LevelFragmentDirections.actionLevelFragmentToQuizFragment(level)
                findNavController().navigate(action)
            }
        }

        if (!hardGreyBackground) {
            hard_level.setOnClickListener {
                level = LevelQuiz.HARD
                prefs.setCurrentLevelQuiz(level)
                val action = LevelFragmentDirections.actionLevelFragmentToQuizFragment(level)
                findNavController().navigate(action)
            }
        }

    }



    private fun defaultShape() {
        medium_level.setBackgroundResource(R.drawable.light_green_circle)
        hard_level.setBackgroundResource(R.drawable.light_green_circle)

        mediumGreyBackground = true
        hardGreyBackground = true
        zoomingAnimation(easy_level, walk_imageView)
    }

    fun zoomingAnimation(textView: TextView, imageView: ImageView) {

        val anim = ValueAnimator.ofFloat(1f, 1.3f)
        anim.duration = 1000
        anim.addUpdateListener { animation ->
            textView.setScaleX(animation.animatedValue as Float)
            textView.setScaleY(animation.animatedValue as Float)
            imageView.setScaleX(animation.animatedValue as Float)
            imageView.setScaleY(animation.animatedValue as Float)
        }
        anim.repeatCount = 15
        anim.repeatMode = ValueAnimator.REVERSE
        anim.start()
    }



    private fun levelShape() {

        when(state){
            null ->{
                defaultShape()
            }
            LevelQuiz.EASY ->{
                hard_level.setBackgroundResource(R.drawable.light_green_circle)
                hardGreyBackground = true
                mediumGreyBackground = false
                zoomingAnimation(medium_level, run_imageView)
            }
            LevelQuiz.NORMAL ->{
                zoomingAnimation(hard_level, bike_imageView)
                mediumGreyBackground = false
                hardGreyBackground = false
            }
            else ->{
                easy_level.setBackgroundResource(R.drawable.green_circle)
                medium_level.setBackgroundResource(R.drawable.green_circle)
                hard_level.setBackgroundResource(R.drawable.green_circle)

                mediumGreyBackground = false
                hardGreyBackground = false
            }
        }

    }
}