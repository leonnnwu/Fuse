package com.playground.android.lwu.fuse

import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right)
        start_frame.setOnClickListener {
            imageView.alpha = 1f
            imageView.setImageDrawable(null)

            val animationDrawable = AnimationDrawable()
            val mipmaps = arrayListOf<Int>(R.mipmap.run1, R.mipmap.run2, R.mipmap.run3, R.mipmap.run4,
                    R.mipmap.run5, R.mipmap.run6, R.mipmap.run7, R.mipmap.run8)

            for (i in 1..8) {
                val drawable = ContextCompat.getDrawable(this, mipmaps[i-1])
                animationDrawable.addFrame(drawable, 200)
            }

            animationDrawable.isOneShot = false
            imageView.setBackgroundDrawable(animationDrawable)
            animationDrawable.start()
        }
    }

    companion object {
        const val ANIMATION_ACTIVITY = 1
    }
}
