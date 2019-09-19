package com.example.gms_demo

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    var fcmToken = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "getInstanceId failed", task.exception)
                    runOnUiThread {
                        tv.text = "getInstanceId failed: ${task.exception}"
                    }
                    return@OnCompleteListener
                }

                runOnUiThread {
                    // Get new Instance ID token
                    val token = task.result?.token ?: ""

                    // Log and toast
                    val msg = "fcm-token: $token"
                    Log.d(TAG, msg)
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()

                    tv.text = msg

                    this.fcmToken = token
                }
            })


        btn.setOnClickListener {
            val cmb = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            cmb.setPrimaryClip(ClipData.newPlainText(null, fcmToken))

            Toast.makeText(baseContext, "Successful copy", Toast.LENGTH_SHORT).show()
        }
    }
}
