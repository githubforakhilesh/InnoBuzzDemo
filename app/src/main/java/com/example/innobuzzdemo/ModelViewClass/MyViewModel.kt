package com.example.innobuzzdemo.ModelViewClass

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.innobuzzdemo.DataClass.MyDataClass
import com.example.innobuzzdemo.Repositery.MyRepositery

class MyViewModel(val context: Context): ViewModel() {
    public fun get_List():MutableLiveData<MyDataClass>{
        return MyRepositery(context).api_call()
}
}