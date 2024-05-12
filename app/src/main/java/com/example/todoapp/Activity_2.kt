<<<<<<< HEAD

=======
>>>>>>> d2c8ba4714721cca58f5b626cb7a08df17986eb8
package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Activity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        supportActionBar!!.hide()

        val i = Intent(this@Activity_2, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(i)
            finish()
        }, 2000)
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> d2c8ba4714721cca58f5b626cb7a08df17986eb8
