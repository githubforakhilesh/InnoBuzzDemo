package com.example.innobuzzdemo.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.innobuzzdemo.R



class home_fragment : Fragment() {


    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_home_fragment, container, false)
        val button = view.findViewById<AppCompatButton>(R.id.home_button)
            button.setOnClickListener(View.OnClickListener {
             findNavController().navigate(R.id.second_fragment)
            })
        return view;
    }


    }
