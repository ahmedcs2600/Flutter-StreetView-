package com.app.flutter_street_view


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import android.app.Activity

class MainActivity: FlutterActivity() {
    companion object {
        const val CHANNEL = "streetView"
    }

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "viewStreetView") {
                Intent(
                        this@MainActivity,
                        StreetViewer::class.java
                ).apply {
                    val lat : String = call.argument("latitude")!!
                    val lng : String= call.argument("longitude")!!
                    val heading : String= call.argument("heading")!!
                    val pitch : String= call.argument("pitch")!!
                    putExtra("latitude",lat)
                    putExtra("longitude",lng)
                    putExtra("heading",heading)
                    putExtra("pitch",pitch)
                }.also {
                    startActivity(it)
                }
            }
            else {
                result.notImplemented()
            }
        }
    }
}
