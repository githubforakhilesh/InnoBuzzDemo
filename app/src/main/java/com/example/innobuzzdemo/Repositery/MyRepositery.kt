package com.example.innobuzzdemo.Repositery

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.innobuzzdemo.DataClass.MyDataClass
import com.example.innobuzzdemo.DataClass.MyDataClassItem
import com.example.innobuzzdemo.Network.ApiInterface
import com.example.innobuzzdemo.Network.Baseurl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepositery(val context: Context) {
    var mutableLiveData : MutableLiveData<MyDataClass> = MutableLiveData()
    var arrayList: MyDataClass = MyDataClass()
    public fun api_call():MutableLiveData<MyDataClass>{
        val apiInterface = Baseurl().get_Instance().create(ApiInterface::class.java)
        val call:Call<MyDataClass> = apiInterface.get_List()
        call.enqueue(object: Callback<MyDataClass>{
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call<MyDataClass>, response: Response<MyDataClass>) {
                if(response.isSuccessful){
                    val myDataClass = response.body()
                        if (myDataClass != null) {
                            for(i in 0 until myDataClass.size){
                           val myDataClass= MyDataClassItem(body = myDataClass.get(i)?.body,
                                                            id = myDataClass.get(i)?.id,
                                                            title = myDataClass.get(i)?.title,
                                                            userId = myDataClass.get(i)?.userId)
                                arrayList.add(myDataClass)
                            }
                            mutableLiveData.value = arrayList

                        }else{
                            Toast.makeText(context,"No data found",Toast.LENGTH_SHORT).show()
                        }
                }else{
                    Toast.makeText(context,""+response.code(),Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<MyDataClass>, t: Throwable) {
                Log.i("error=",t.toString())
                Toast.makeText(context,""+t,Toast.LENGTH_SHORT).show()
            }
        })

        return mutableLiveData

    }

}