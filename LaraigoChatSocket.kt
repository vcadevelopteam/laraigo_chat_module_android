package com.example.a7minapp

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.embedding.android.FlutterView
import io.flutter.plugin.common.MethodChannel

class LaraigoChatSocket {

    private lateinit var flutterEngine: FlutterEngine

    private val FLUTTER_ENGINE_ID = "flutter_engine"
    private val CHANNEL = "laraigo_chat_communication_channel"


    fun initChatSocket(integrationId: String,context: Context) {
        setupFlutterEngine(context)
        setupMethodChannel(integrationId)
        launchFlutterModule(context)
    }


    private fun setupFlutterEngine(context: Context) {
        createAndConfigureFlutterEngine(context)
        FlutterEngineCache
            .getInstance()
            .put(FLUTTER_ENGINE_ID, flutterEngine)
    }

    private fun createAndConfigureFlutterEngine(context: Context) {
        flutterEngine = FlutterEngine(context)
        flutterEngine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())

    }

    private fun setupMethodChannel(integrationId: String) {
        val mapWithValues = hashMapOf("integrationId" to integrationId)

        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { call, result ->
            if (call.method.contentEquals("testingSendData")) {
                result.success(mapWithValues);
            }
        }
    }

    private fun launchFlutterModule(context: Context) {
        ContextCompat.startActivity(context, getFlutterIntent(context), null)
    }

    private fun getFlutterIntent(context: Context): Intent {
        return FlutterActivity
            .withCachedEngine(FLUTTER_ENGINE_ID)
            .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
            .build(context)
    }
}