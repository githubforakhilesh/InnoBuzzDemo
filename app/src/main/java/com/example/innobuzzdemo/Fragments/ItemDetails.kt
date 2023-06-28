package com.example.innobuzzdemo.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.example.innobuzzdemo.R
import com.example.innobuzzdemo.SharedPreference.MySharedPref


class ItemDetails : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_details, container, false)
        val id = view.findViewById<AppCompatTextView>(R.id.id_textview)
        val userId = view.findViewById<AppCompatTextView>(R.id.userId_textview)
        val title = view.findViewById<AppCompatTextView>(R.id.title_textview)
        val body = view.findViewById<AppCompatTextView>(R.id.body_textview)
        id.setText("Id: "+context?.let { MySharedPref(it).getPreferences(MySharedPref.id) })
        userId.setText("userId: "+context?.let { MySharedPref(it).getPreferences(MySharedPref.userId) })
        title.setText("title: "+context?.let { MySharedPref(it).getPreferences(MySharedPref.title) })
        body.setText("body: "+context?.let { MySharedPref(it).getPreferences(MySharedPref.body) })

        return view;
    }


}