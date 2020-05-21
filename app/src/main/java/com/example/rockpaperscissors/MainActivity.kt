package com.example.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toast_layout.*
import kotlinx.android.synthetic.main.toast_layout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_computerselection.visibility = View.INVISIBLE
        iv_playerselection.visibility = View.INVISIBLE
    }

    var computerscore = 0
    var playerscore = 0

    fun show_toast(zz:String, yy:Int) {
        val inflater = layoutInflater
        val layout: View = inflater.inflate(R.layout.toast_layout, findViewById(R.id.toast_root))
        val textToShow: TextView = layout.toast_text
        val imageToShow: ImageView = layout.toast_image

        textToShow.text = zz
        if (zz=="I Win !!" && yy==1) {
            imageToShow.setImageResource(R.drawable.rock)
        } else
        if (zz=="I Win !!" && yy==2) {
            imageToShow.setImageResource(R.drawable.paper)
        } else
        if (zz=="I Win !!" && yy==3) {
            imageToShow.setImageResource(R.drawable.scissors)
        } else
        if (zz=="You Win !! :D" && yy==1) {
            imageToShow.setImageResource(R.drawable.paper)
        } else
        if (zz=="You Win !! :D" && yy==2) {
            imageToShow.setImageResource(R.drawable.scissors)
        } else
        if (zz=="You Win !! :D" && yy==3) {
            imageToShow.setImageResource(R.drawable.rock)
        }
        else {
            imageToShow.setImageResource(R.drawable.ic_launcher_background)
        }


        with (Toast(applicationContext)) {
            setGravity(Gravity.CENTER, 0, 800)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }

    fun onselection (view: View) {
        val butpressed:Button = view as Button
        when (butpressed.id) {
            R.id.bt_rock -> iv_playerselection.setImageResource(R.drawable.rock)
            R.id.bt_paper -> iv_playerselection.setImageResource(R.drawable.paper)
            R.id.bt_scissors -> iv_playerselection.setImageResource(R.drawable.scissors)
        }
        play_turn(butpressed)
    }

    fun play_turn(butpressed:Button) {

        var score = findViewById<TextView>(R.id.tv_score)
        val computerselection = (1..3).random()
        iv_computerselection.visibility = View.VISIBLE
        iv_playerselection.visibility = View.VISIBLE


        if (computerselection == 1) {
            iv_computerselection.setImageResource(R.drawable.rock)
        }
        if (computerselection == 2) {
            iv_computerselection.setImageResource(R.drawable.paper)
        }
        if (computerselection == 3) {
            iv_computerselection.setImageResource(R.drawable.scissors)
        }

        if (butpressed.id == R.id.bt_rock && computerselection == 1) {
            show_toast("Its a Draw. Play Again !!", 4)
        }
        if (butpressed.id == R.id.bt_paper && computerselection == 2) {
            show_toast("Its a Draw. Play Again !!",4)
        }
        if (butpressed.id == R.id.bt_scissors && computerselection == 3) {
            show_toast("Its a Draw. Play Again !!",4)
        }
        if (butpressed.id == R.id.bt_rock && computerselection == 2) {
            show_toast("I Win !!", computerselection)
            computerscore += 1
            score.text = "Score: Player " + playerscore + " : " + computerscore + " Computer"
        }
        if (butpressed.id == R.id.bt_rock && computerselection == 3) {
            show_toast("You Win !! :D", computerselection)
            playerscore += 1
            score.text = "Score: Player " + playerscore + " : " + computerscore + " Computer"
        }
        if (butpressed.id == R.id.bt_paper && computerselection == 3) {
            show_toast("I Win !!", computerselection)
            computerscore += 1
            score.text = "Score: Player " + playerscore + " : " + computerscore + " Computer"
        }
        if (butpressed.id == R.id.bt_paper && computerselection == 1) {
            show_toast("You Win !! :D", computerselection)
            playerscore += 1
            score.text = "Score: Player " + playerscore + " : " + computerscore + " Computer"
        }
        if (butpressed.id == R.id.bt_scissors && computerselection == 1) {
            show_toast("I Win !!", computerselection)
            computerscore += 1
            score.text = "Score: Player " + playerscore + " : " + computerscore + " Computer"
        }
        if (butpressed.id == R.id.bt_scissors && computerselection == 2) {
            show_toast("You Win !! :D", computerselection)
            playerscore += 1
            score.text = "Score: Player " + playerscore + " : " + computerscore + " Computer"
        }
    }
}
