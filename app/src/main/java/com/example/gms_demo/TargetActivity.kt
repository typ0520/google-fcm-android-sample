package com.example.gms_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_target.*

class TargetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target)

        tv.text = intent.getBooleanExtra("isFromPush", false).toString()
        tv2.text = intent.getStringExtra("payload")

        tv3.text = intent.toURI().toString()
    }
}
