package com.example.myquizapp

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FinalFragment : Fragment() {

    private var player: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_final, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        cheersSound()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun cheersSound(){
        try {
            player = MediaPlayer.create(requireContext(), R.raw.cheers)
            player!!.isLooping = false
            player!!.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {

        if (player != null) {
            player!!.stop()
        }
        super.onDestroy()
    }


}