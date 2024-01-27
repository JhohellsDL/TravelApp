package com.example.travelapp

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.travelapp.databinding.ActivityMain2Binding


private const val ANIMATION_DURATION = 1000L
class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.imageVisibility.setOnClickListener {
            val currentInputType = binding.editTextPassword.inputType
            binding.editTextPassword.inputType = if (currentInputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            } else {
                InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
            binding.editTextPassword.setSelection(binding.editTextPassword.text.length)
        }
        binding.cardButtonCreate.setOnClickListener {
            binding.textTitle.fadeInAndMoveUpAndChanged()
            moveTwoText(
                binding.cardEmail,
                binding.cardPassword,
                binding.cardButtonLogin
            )

        }
    }
    private fun TextView.fadeInAndMoveUpAndChanged() {
        alpha = 0f
        translationY = 0f

        val fadeInAnimator = ObjectAnimator.ofFloat(this, "alpha", 0f, 1f)
        fadeInAnimator.duration = ANIMATION_DURATION

        val moveUpAnimator = ObjectAnimator.ofFloat(this, "translationX", -30f, 10f)
        moveUpAnimator.duration = ANIMATION_DURATION

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(fadeInAnimator, moveUpAnimator)
        animatorSet.start()
    }

    private fun moveTwoText(cardView1: CardView, cardView2: CardView, cardView3: CardView) {
        cardView1.alpha = 0f
        cardView2.alpha = 0f
        cardView3.alpha = 0f

        binding.cardForgot.alpha = 0f
        binding.cardCreate.alpha = 0f

        val fadeInAnimator1 = ObjectAnimator.ofFloat(cardView1, "alpha", 0f, 1f)
        fadeInAnimator1.duration = ANIMATION_DURATION
        val fadeInAnimator2 = ObjectAnimator.ofFloat(cardView2, "alpha", 0f, 1f)
        fadeInAnimator2.duration = ANIMATION_DURATION
        val fadeInAnimator3 = ObjectAnimator.ofFloat(cardView3, "alpha", 0f, 1f)
        fadeInAnimator2.duration = ANIMATION_DURATION

        val animator1 = ObjectAnimator.ofFloat(cardView1, "translationX", -40f, 10f)
        animator1.duration = ANIMATION_DURATION
        val animator2 = ObjectAnimator.ofFloat(cardView2, "translationX", -40f, 10f)
        animator2.duration = ANIMATION_DURATION
        val animator3 = ObjectAnimator.ofFloat(cardView3, "translationX", -40f, 10f)
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
        animator2.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                animator3.start()
                fadeInAnimator3.start()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })
        animator3.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                moveTwoCard(
                    binding.cardForgot,
                    binding.cardCreate
                )
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })

        fadeInAnimator1.start()
        animator1.start()
    }

    private fun moveTwoCard(cardView1: CardView, cardView2: CardView) {
        cardView1.alpha = 0f
        cardView2.alpha = 0f

        val fadeInAnimator1 = ObjectAnimator.ofFloat(cardView1, "alpha", 0f, 1f)
        fadeInAnimator1.duration = ANIMATION_DURATION
        val fadeInAnimator2 = ObjectAnimator.ofFloat(cardView2, "alpha", 0f, 1f)
        fadeInAnimator2.duration = ANIMATION_DURATION

        val animator1 = ObjectAnimator.ofFloat(cardView1, "translationY", -30f, 10f)
        animator1.duration = ANIMATION_DURATION
        val animator2 = ObjectAnimator.ofFloat(cardView2, "translationY", -30f, 10f)
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

}