package com.example.innobuzzdemo.AccessbilityService

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import java.lang.Exception


class MyService : AccessibilityService() {
    override fun onAccessibilityEvent(p0: AccessibilityEvent?) {
        val packageName = p0?.packageName.toString()
        val packageManager = this.packageManager
        val applicationInfo = packageManager.getApplicationInfo(packageName,0)
        val applicationlebel = packageManager.getApplicationLabel(applicationInfo)
        Log.d("app name ",applicationlebel.toString())

        try {
            Handler(Looper.getMainLooper()).post(Runnable {
                Toast.makeText(this.getApplicationContext(), ""+applicationlebel.toString(), Toast.LENGTH_SHORT
                ).show()
            })
        }catch(e: Exception){
        // Toast.makeText()
        }

    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    override fun onServiceConnected() {
       super.onServiceConnected()
        val info = AccessibilityServiceInfo()
        info.apply {
            eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED or AccessibilityEvent.TYPE_VIEW_FOCUSED
            feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN
            notificationTimeout = 100
        }

        this.serviceInfo = info

    }
}


