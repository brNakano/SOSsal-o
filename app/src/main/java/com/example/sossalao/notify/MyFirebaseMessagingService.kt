package com.example.sossalao.notify

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.sossalao.Prefs
import com.example.sossalao.R
import com.example.sossalao.ui.ProductDetailActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService(){

    val TAG = "firebase"
    val context: Context get() = this
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Novo token: $token")
        val key = "AAAAeJXv0bU:APA91bHMVTPBRC-paw4S5yRsmAuU6E8wiBOl9XzgZh2Wwq2mPGwQ4Yl0BvDgGufDgePxEmDrzHg94SMsEZmu17pthUjsyvnWaDdnrxyOOclRlwoz0yImo-RsD5jvhznzu_kZfScU306X"

        Prefs.setString("FB_TOKEN", token!!)
        Prefs.setString("KEY_SERVER", key)
    }


    override fun onMessageReceived(mensagemRemota: RemoteMessage) {
        Log.d(TAG, "onMessageReceived")


        if (mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Titulo da mensagem: $titulo")
            Log.d(TAG, "Corpo da mensagem: $corpo")

            showNotification(mensagemRemota)
        }
    }

    private fun showNotification(mensagemRemota: RemoteMessage) {


        val intent = Intent(this, ProductDetailActivity::class.java)

        val titulo = mensagemRemota?.notification?.title?: getString(R.string.app_name)
        var mensagem = mensagemRemota?.notification?.body!!


        NotificationUtil.create(1, intent, titulo, mensagem)
    }
}