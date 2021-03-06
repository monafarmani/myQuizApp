package com.example.myquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {

    lateinit var prefs: SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefs = SharedPreferencesHelper(requireContext())
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        view.start_button.setOnClickListener {
            if ( et_name.text.toString().isEmpty()) {
                Toast.makeText(context, "Please enter your name.", Toast.LENGTH_SHORT).show()

            } else {
                findNavController().navigate(R.id.action_mainFragment_to_levelFragment)
                val name = et_name.text.toString()
                prefs.setName(name)
            }
        }

        return view
    }

}