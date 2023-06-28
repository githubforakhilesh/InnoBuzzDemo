package com.example.innobuzzdemo.SharedPreference

import android.annotation.SuppressLint
import android.content.Context
import android.preference.PreferenceManager

class MySharedPref(val context: Context) {
    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    companion object{
        val userId:String = "userId"
        val id:String = "Id"
        val title:String = "title"
        val body:String = "body"
    }
    @SuppressLint("SuspiciousIndentation")
    fun setPreferences(keyString:String, value:String){
      val editor = sharedPreferences.edit()
        editor.putString(keyString,value)
        editor.apply()
    }
     fun getPreferences(keyString: String): String? {
         var sh = sharedPreferences.getString(keyString,"")
         return  sh
     }
}