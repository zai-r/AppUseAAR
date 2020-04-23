package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.notificationsmodule.ActivityNotifications

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // TODO: startActivity時のちらつき仮対処
        val intent1 =  Intent(this, ActivityNotifications::class.java)
                .addFlags(
                        Intent.FLAG_ACTIVITY_NO_ANIMATION
                                or Intent.FLAG_ACTIVITY_TASK_ON_HOME
                )
        val intents = arrayOf(intent1, this.intent)
        this.startActivities(intents)

        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()

            this.startActivity(
                    Intent(this, ActivityNotifications::class.java)
                            .addFlags(
                            Intent.FLAG_ACTIVITY_NO_ANIMATION
                                    or Intent.FLAG_ACTIVITY_TASK_ON_HOME
                            )
            )
            //overridePendingTransition(R.anim.slideinleft, R.anim.slideinright)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
