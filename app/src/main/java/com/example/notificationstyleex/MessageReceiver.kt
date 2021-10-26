package com.example.notificationstyleex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.RemoteInput

class MessageReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("MessageReceiver", "onReceive()")
        val msg = getMessageText(intent)
        Log.d("MessageReceiver", "답장 메시지 : ${msg}")
    }

    private fun getMessageText(intent: Intent): CharSequence? {
        return RemoteInput.getResultsFromIntent(intent)?.getCharSequence("key_text_reply")
    }

}

