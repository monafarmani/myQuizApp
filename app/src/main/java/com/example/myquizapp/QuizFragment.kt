package com.example.myquizapp

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.media.MediaPlayer.*
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.fragment_quiz.*


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

        var levelQuiz = LevelQuiz.EASY
        arguments?.let {
            levelQuiz = it.get("levelQuiz") as LevelQuiz

        }

        if(levelQuiz == LevelQuiz.EASY){
            list = Constants().easyList()
        }else if(levelQuiz == LevelQuiz.NORMAL){
            list = Constants().normalList()
        }else{
            list = Constants().hardList()
            
        }


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
//        timer_textView.text = "${(timerDuration / 1000).toString() + "Seconds"}"
    //    startTimer(timerDuration)

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

                        val action = QuizFragmentDirections.actionQuizFragmentToFinishFragment(falseNumber)
                        findNavController().navigate(action)
//                        findNavController().navigate(R.id.action_quizFragment_to_FinishFragment)
                    }, 1000)
                }

        } else {


            setHearts()

            text.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))

            false_textView.visibility = View.VISIBLE

                animateRocket()

                try {
                    player = MediaPlayer.create(requireContext(), R.raw.falsesound)
                    player!!.isLooping = false
                    player!!.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            Handler().postDelayed({
                false_textView.visibility = View.INVISIBLE
            }, 1000)

            if (falseNumber == 3) {
                customDialog()
                countDownTimer?.let {
                    it.cancel()
                }
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
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.redo_textView.setOnClickListener({

            currentPosition = 0
            falseNumber = 0
            countDownTimer?.let {
                it.cancel()
            }

//            timer_textView.text = "${(timerDuration / 1000).toString() + "Seconds"}"

            defaultQuestion()
            customDialog.dismiss()
        })

        customDialog.menu_textView.setOnClickListener({

            customDialog.dismiss()
            findNavController().navigate(R.id.action_quizFragment_to_levelFragment)
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

       // startTimer(timerDuration)

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

        countDownTimer = object : CountDownTimer(second, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer_textView.text = (millisUntilFinished / 1000).toString() + " seconds"
            }

            override fun onFinish() {
                Toast.makeText(context, "Time is over!", Toast.LENGTH_SHORT).show()

//                Handler().postDelayed({
//                    customDialog()
//                }, 1000)
                customDialog()
                countDownTimer!!.cancel()

            }
        }.start()
    }

    private fun animateRocket(){
        val shake = AnimationUtils.loadAnimation(requireContext() , R.anim.shake_animation)
        flag_imageView.animation = shake
    }

    override fun onDestroy() {

        if (player != null) {
            player!!.stop()
        }
        super.onDestroy()
    }

}


