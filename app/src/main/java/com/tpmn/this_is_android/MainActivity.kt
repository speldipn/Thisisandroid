package com.tpmn.this_is_android

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tpmn.this_is_android.databinding.ActivityMainBinding
import com.tpmn.this_is_android.thread.ThreadExample
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var total = 0
    var started = false
    var handler: Handler? = null

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Log.d(TAG, ">>>>> start")
        run()
        Log.d(TAG, ">>>>> end")
    }

    private fun run() {
        handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                val minute = String.format("%02d", total / 60)
                val second = String.format("%02d", total % 60)
                binding.textView.text = "${minute}:${second}"
            }
        }
        binding.startButton.setOnClickListener {
            started = true
            thread(start = true) {
                while (started) {
                    Thread.sleep(1000)
                    if (started) {
                        total = total + 1
                        handler?.sendEmptyMessage(0)
                    }
                }
            }
        }
        binding.stopButton.setOnClickListener {
            started = false
            total = 0
            binding.textView.text = "00:00"
        }
    }

    companion object {
        val TAG = "thisisandroid"
    }

}