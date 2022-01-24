package com.example.myquizapp

import android.annotation.SuppressLint
import android.app.Dialog
import android.media.MediaParser
import android.media.MediaPlayer
import android.media.MediaPlayer.*
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.fragment_quiz.*
import java.lang.Exception


class QuizFragment : Fragment() {

    private var list: ArrayList<ModelClass>? = null
    private var currentPosition: Int = 0
    private var falseNumber = 0
    private var player: MediaPlayer? = null
    private var countDownTimer: CountDownTimer? = null
    private var timerDuration: Long = 30000


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = Constants().createList()

        setQuestion()

        country_one.setOnClickListener {
            checkAnswer(1)
        }
        country_two.setOnClickListener {
            checkAnswer(2)
        }
        country_three.setOnClickListener {
            checkAnswer(3)
        }
        country_four.setOnClickListener {
            checkAnswer(4)
        }
    }

    private fun setQuestion() {


        val question = list!![currentPosition]
        val i = currentPosition + 1
        progressBar.progress = i
      //  timer_textView.text = "${(timerDuration / 1000).toString() + "Seconds"}"
      //  startTimer(0)

        progress_textView.setText(i.toString() + "/" + progressBar.max)

        flag_imageView.setImageResource(question.image)
        country_one.text = question.optionOne
        country_two.text = question.optionTwo
        country_three.text = question.optionThree
        country_four.text = question.optionFour

        val countryList = countryList()

        for (country in countryList) {
            country.setBackgroundResource(R.drawable.background_options)
            country.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

        }
    }


    private fun checkAnswer(number: Int) {
        val countryList = countryList()
        val text = countryList[number - 1]
        val question = list!![currentPosition]
        val correctAnswer = question.correctAnswer


            if (number == correctAnswer) {

                try {
                    player = MediaPlayer.create(requireContext(), R.raw.correctsound)
                    player!!.isLooping = false
                    player!!.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                text.setBackgroundResource(R.drawable.green_background)

                correct_textView.visibility = View.VISIBLE

                Handler().postDelayed({
                    correct_textView.visibility = View.INVISIBLE
                }, 1000)


                if (currentPosition < 9) {
                    currentPosition++

                    Handler().postDelayed({
                        setQuestion()
                    }, 1000)

                } else {
                    Handler().postDelayed({
                        findNavController().navigate(R.id.action_quizFragment_to_resultFragment)
                    }, 1000)
                }

        } else {


            setHearts()

            text.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))

            false_textView.visibility = View.VISIBLE

            Handler().postDelayed({
                false_textView.visibility = View.INVISIBLE
            }, 1000)

            if (falseNumber == 3) {
                customDialog()
            }

        }
    }

    private fun countryList(): ArrayList<TextView> {
        val countryList: ArrayList<TextView> = ArrayList()
        countryList.add(country_one)
        countryList.add(country_two)
        countryList.add(country_three)
        countryList.add(country_four)

        return countryList

    }

    private fun heartList(): ArrayList<ImageView> {
        val heartList: ArrayList<ImageView> = ArrayList()
        heartList.add(heart_one)
        heartList.add(heart_two)
        heartList.add(hear_three)

        return heartList
    }


    private fun customDialog() {
        val customDialog = Dialog(requireContext())
        customDialog.setContentView(R.layout.custom_dialog)

        customDialog.redo_textView.setOnClickListener({

            currentPosition = 0
            falseNumber = 0
       //     countDownTimer!!.cancel()
            defaultQuestion()
            customDialog.dismiss()
        })
        customDialog.show()
    }

    private fun setHearts() {
        val heartList = heartList()
        falseNumber++
        heartList[falseNumber - 1].setColorFilter(
            ContextCompat.getColor(
                requireContext(),
                R.color.dark_gray
            )
        )


    }

    private fun defaultQuestion() {

        val question = list!![currentPosition]
        val i = currentPosition + 1
        progressBar.progress = i
    //    timer_textView.text = "${(timerDuration / 1000).toString() + "Seconds"}"
    //    startTimer(0)

        progress_textView.setText(i.toString() + "/" + progressBar.max)

        flag_imageView.setImageResource(question.image)
        country_one.text = question.optionOne
        country_two.text = question.optionTwo
        country_three.text = question.optionThree
        country_four.text = question.optionFour

        val countryList = countryList()

        for (country in countryList) {
            country.setBackgroundResource(R.drawable.background_options)
            country.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

        }
        val heartList = heartList()
        for (heart in heartList) {
            heart.setColorFilter(ContextCompat.getColor(requireContext(), R.color.red))

        }

    }

    private fun startTimer(second: Long) {

        countDownTimer = object : CountDownTimer(timerDuration - second, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer_textView.text = (millisUntilFinished / 1000).toString() + " seconds"
            }

            override fun onFinish() {
                Toast.makeText(context, "Time is over!", Toast.LENGTH_SHORT).show()

                Handler().postDelayed({
                    customDialog()
                }, 1000)
                countDownTimer!!.cancel()
            }
        }.start()
    }

    override fun onDestroy() {

        if (player != null) {
            player!!.stop()
        }
        super.onDestroy()
    }

}


