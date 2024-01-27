package com.example.travelapp

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.travelapp.databinding.ActivityMainBinding


private const val ANIMATION_DURATION = 1000L

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moveTwoText(binding.textText1, binding.textText2)
        binding.cardButton.fadeInAndMoveUp()

        binding.buttonNext.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }

    }

    private fun moveTwoText(textView1: TextView, textView2: TextView) {
        textView1.alpha = 0f
        textView2.alpha = 0f

        val fadeInAnimator1 = ObjectAnimator.ofFloat(textView1, "alpha", 0f, 1f)
        fadeInAnimator1.duration = ANIMATION_DURATION
        val fadeInAnimator2 = ObjectAnimator.ofFloat(textView2, "alpha", 0f, 1f)
        fadeInAnimator2.duration = ANIMATION_DURATION

        val animator1 = ObjectAnimator.ofFloat(textView1, "translationY", 0f, 10f)
        animator1.duration = ANIMATION_DURATION
        val animator2 = ObjectAnimator.ofFloat(textView2, "translationY", 0f, 10f)
        animator2.duration = ANIMATION_DURATION

        animator1.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                animator2.start()
                fadeInAnimator2.start()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })

        fadeInAnimator1.start()
        animator1.start()
    }

    private fun CardView.fadeInAndMoveUp() {
        val fadeInAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val translateAnimator = ObjectAnimator.ofFloat(this, "translationY", 0f, -20f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(fadeInAnimator, translateAnimator)
        animatorSet.start()
    }
}