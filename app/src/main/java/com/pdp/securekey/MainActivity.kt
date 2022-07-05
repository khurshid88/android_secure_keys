package com.pdp.securekey

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var serverKey = BuildConfig.SERVER_KEY

    init {
        System.loadLibrary("keys")
    }

    external fun getPublicKey(): String?
    external fun getPrivateKey(): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", serverKey)

        Log.d("MainActivity", getPublicKey().toString())
        Log.d("MainActivity", getPrivateKey().toString())
    }
}