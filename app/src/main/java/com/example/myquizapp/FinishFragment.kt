package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_finish.*


class FinishFragment : Fragment() {

    lateinit var prefs: SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.hide()
        prefs = SharedPreferencesHelper(requireContext())

        return inflater.inflate(R.layout.fragment_finish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name: String? = prefs.getName()
        username.text = " dear $name"

        var falseNumber = 0
        arguments?.let {
            falseNumber = it.get("false_number") as Int

        }

        when(falseNumber){
            0 -> rating_bar.rating = 3F
            1 -> rating_bar.rating = 2F
            2 -> rating_bar.rating = 1F
        }

        var level = prefs.getCurrentLevelQuiz()

        var state = prefs.getState()

        state?.let {
            if(state.ordinal < level.ordinal){
                prefs.setState(level)
            }
        } ?: run {
            prefs.setState(level)
        }




        replay.setOnClickListener {
            findNavController().navigate(R.id.action_FinishFragment_to_quizFragment)

        }
        share.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                var shareMessage =
                    "\nI solved a new level in Flag Quiz! Try this game on Android:\n\n"
                shareMessage =
                    """
                    ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                    
                    
                    """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }

        menu.setOnClickListener {

                findNavController().navigate(R.id.action_finishFragment_to_levelFragment)
            }


        next.setOnClickListener {
            var level = prefs.getCurrentLevelQuiz()

            if (level == LevelQuiz.EASY) {
                var nextLevel = LevelQuiz.NORMAL
                prefs.setCurrentLevelQuiz(nextLevel)
                val action = FinishFragmentDirections.actionFinishFragmentToQuizFragment(nextLevel)
                findNavController().navigate(action)
            } else if (level == LevelQuiz.NORMAL) {
                var nextLevel = LevelQuiz.HARD
                prefs.setCurrentLevelQuiz(nextLevel)
                val action = FinishFragmentDirections.actionFinishFragmentToQuizFragment(nextLevel)
                findNavController().navigate(action)
            } else {
                findNavController().navigate(R.id.action_finishFragment_to_finalFragment)

            }
        }
    }
}