package com.example.notificationstyleex

import android.app.*
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaSession2Service
import android.os.Build
import android.os.Bundle
import android.support.v4.media.session.PlaybackStateCompat
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import androidx.media.session.MediaButtonReceiver
import com.example.notificationstyleex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var builder: NotificationCompat.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val ch = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            NotificationManagerCompat.from(this).createNotificationChannel(ch)
        }

        initBuilder()

    }

    private fun initBuilder() {
        builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    }

    fun handleBicPictureStyleButton(view: View) {

        builder
            .setContentTitle("Big picture style")
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.cat))
            )

        NotificationManagerCompat.from(this).notify(1, builder.build())
    }

    fun handleBicTextStyleButton(v: View) {
        builder
            .setContentTitle("Big Text style")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("\uD83D\uDE00 \uD83D\uDE03 \uD83D\uDE04 \uD83D\uDE01 \uD83D\uDE06 \uD83D\uDE05 \uD83D\uDE02 \uD83E\uDD23 \uD83E\uDD72 ☺️ \uD83D\uDE0A \uD83D\uDE07 \uD83D\uDE42 \uD83D\uDE43 \uD83D\uDE09 \uD83D\uDE0C \uD83D\uDE0D \uD83E\uDD70 \uD83D\uDE18 \uD83D\uDE17 \uD83D\uDE19 \uD83D\uDE1A \uD83D\uDE0B \uD83D\uDE1B \uD83D\uDE1D \uD83D\uDE1C \uD83E\uDD2A \uD83E\uDD28 \uD83E\uDDD0 \uD83E\uDD13 \uD83D\uDE0E \uD83E\uDD78 \uD83E\uDD29 \uD83E\uDD73 \uD83D\uDE0F \uD83D\uDE12 \uD83D\uDE1E \uD83D\uDE14 \uD83D\uDE1F \uD83D\uDE15 \uD83D\uDE41 ☹️ \uD83D\uDE23 \uD83D\uDE16 \uD83D\uDE2B \uD83D\uDE29 \uD83E\uDD7A \uD83D\uDE22 \uD83D\uDE2D \uD83D\uDE24 \uD83D\uDE20 \uD83D\uDE21 \uD83E\uDD2C \uD83E\uDD2F \uD83D\uDE33 \uD83E\uDD75 \uD83E\uDD76 \uD83D\uDE31 \uD83D\uDE28 \uD83D\uDE30 \uD83D\uDE25 \uD83D\uDE13 \uD83E\uDD17 \uD83E\uDD14 \uD83E\uDD2D \uD83E\uDD2B \uD83E\uDD25 \uD83D\uDE36 \uD83D\uDE10 \uD83D\uDE11 \uD83D\uDE2C \uD83D\uDE44 \uD83D\uDE2F \uD83D\uDE26 \uD83D\uDE27 \uD83D\uDE2E \uD83D\uDE32 \uD83E\uDD71 \uD83D\uDE34 \uD83E\uDD24 \uD83D\uDE2A \uD83D\uDE35 \uD83E\uDD10 \uD83E\uDD74 \uD83E\uDD22 \uD83E\uDD2E \uD83E\uDD27 \uD83D\uDE37 \uD83E\uDD12 \uD83E\uDD15 \uD83E\uDD11 \uD83E\uDD20 \uD83D\uDE08 \uD83D\uDC7F \uD83D\uDC79 \uD83D\uDC7A \uD83E\uDD21 \uD83D\uDCA9 \uD83D\uDC7B \uD83D\uDC80 ☠️ \uD83D\uDC7D \uD83D\uDC7E \uD83E\uDD16 \uD83C\uDF83 \uD83D\uDE3A \uD83D\uDE38 \uD83D\uDE39 \uD83D\uDE3B \uD83D\uDE3C \uD83D\uDE3D \uD83D\uDE40 \uD83D\uDE3F \uD83D\uDE3E")
            )
        NotificationManagerCompat.from(this).notify(2, builder.build())
    }

    fun handleInBoxStyleButton(v: View) {

        builder
            .setContentTitle("InBox style")
            .setStyle(
                NotificationCompat.InboxStyle()
                    .addLine("email1")
                    .addLine("email2")
                    .addLine("email13")
                    .addLine("email14")
                    .addLine("email15")
                    .addLine("email16")
            )
        NotificationManagerCompat.from(this).notify(3, builder.build())

    }

    fun handleMessagingStyleButton(v: View) {

        val person1 = androidx.core.app.Person.Builder().setName("hyejin").build()
        val person2 = androidx.core.app.Person.Builder().setName("jineee").build()

        val msg1 = NotificationCompat.MessagingStyle.Message("hi", System.currentTimeMillis(),person1)
        val msg2 = NotificationCompat.MessagingStyle.Message("oh- hi", System.currentTimeMillis(),person2)

        builder
            .setContentTitle("Message style")
            .setStyle(
                NotificationCompat.MessagingStyle("NotificationExApp")
                    .addMessage(msg1)
                    .addMessage(msg2)
            )
        NotificationManagerCompat.from(this).notify(3, builder.build())

    }

    fun handleMediaStyleButton(v: View) {

        val prevPendingIntent = MediaButtonReceiver.buildMediaButtonPendingIntent(this, PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS)
        val pausePendingIntent = MediaButtonReceiver.buildMediaButtonPendingIntent(this, PlaybackStateCompat.ACTION_PAUSE)
        val nextPendingIntent = MediaButtonReceiver.buildMediaButtonPendingIntent(this, PlaybackStateCompat.ACTION_SKIP_TO_NEXT)

        builder
            .setContentTitle("Wonderful music")
            .setContentText("My Awesome Band")
            .addAction(R.drawable.ic_baseline_skip_previous_24,"prev", prevPendingIntent)
            .addAction(R.drawable.ic_baseline_pause_24,"pause", pausePendingIntent)
            .addAction(R.drawable.ic_baseline_skip_next_24,"next", nextPendingIntent)
            .setStyle(androidx.media.app.NotificationCompat.MediaStyle()
                .setShowActionsInCompactView(0,1,2)
            )
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.cover))


        NotificationManagerCompat.from(this).notify(3, builder.build())
    }

    fun reply(v:View){
        val KEY_TEXT_REPLY = "key_text_reply"
        var remoteInput = RemoteInput.Builder(KEY_TEXT_REPLY)
            .setLabel("답장을 입력하세요.")
            .build()

        var replyPendingIntent: PendingIntent =
            PendingIntent.getBroadcast(applicationContext, 1000,
                getMessageReplyIntent(1000),
                PendingIntent.FLAG_UPDATE_CURRENT)

        val action = NotificationCompat.Action.Builder(R.drawable.ic_baseline_message_24, "REPLY", replyPendingIntent)
            .addRemoteInput(remoteInput)

        val person1 = androidx.core.app.Person.Builder().setName("hyejin").build()
        val msg1 = NotificationCompat.MessagingStyle.Message("hi", System.currentTimeMillis(),person1)

        builder
            .setContentTitle("Message style")
            .addAction(action.build())
            .setStyle(
                NotificationCompat.MessagingStyle("NotificationExApp")
                    .addMessage(msg1)
            )
        NotificationManagerCompat.from(this).notify(5, builder.build())
    }

    private fun getMessageReplyIntent(conversationId: Int): Intent {
        return Intent(this, MessageReceiver::class.java)
    }

    companion object {
        private const val CHANNEL_ID = "1000"
        private const val CHANNEL_NAME = "Notification Ex"
    }
}