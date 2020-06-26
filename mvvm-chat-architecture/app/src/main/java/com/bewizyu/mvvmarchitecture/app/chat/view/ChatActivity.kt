package com.bewizyu.mvvmarchitecture.app.chat.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.intentservice.chatui.ChatView
import co.intentservice.chatui.models.ChatMessage
import com.bewizyu.mvvmarchitecture.R
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*
import timber.log.Timber
import java.sql.Timestamp


class ChatActivity : AppCompatActivity() {

    private lateinit var chatView: ChatView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        chatView = chat_view

        chatView.addMessage(ChatMessage("Hello from Morocco",Timestamp(System.currentTimeMillis()).time, ChatMessage.Type.SENT ))
        chatView.addMessage(ChatMessage("Hello from France",Timestamp(System.currentTimeMillis()).time, ChatMessage.Type.RECEIVED ))
        chatView.addMessage(ChatMessage("Hello from Spain",Timestamp(System.currentTimeMillis()).time, ChatMessage.Type.RECEIVED ))
        chatView.addMessage(ChatMessage("How are doing ? ",Timestamp(System.currentTimeMillis()).time, ChatMessage.Type.SENT ))
        chatView.addMessage(ChatMessage("fine thanks !!  ",Timestamp(System.currentTimeMillis()).time, ChatMessage.Type.RECEIVED ))


        chatView.setOnSentMessageListener {
            sendMessage(it)
            chatView.inputEditText.setText("")
            false
        }
        addMessagesListener()
    }

    private fun addMessagesListener(){
        // TODO : https://firebase.google.com/docs/database/android/lists-of-data



    }


    private fun sendMessage(msg: ChatMessage){
        // TODO : https://firebase.google.com/docs/database/android/lists-of-data

    }

    companion object {
        val SENT_TO : String = "e3gVz5sZuuVFbba0YR9aMdhej2r2"
        fun getIntent(context: Context): Intent {
            return Intent(context, ChatActivity::class.java)
        }
    }
}

@IgnoreExtraProperties
 class ServerMessage(val createdAt: Long = 0 , val isFriendRequest: Boolean = false, val messageText: String = "", val type: String= "")