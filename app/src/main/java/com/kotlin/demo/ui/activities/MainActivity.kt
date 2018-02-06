package com.kotlin.demo.ui.activities

import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import com.kotlin.demo.R
import com.kotlin.demo.ui.fragments.FragmentVIewOne
import com.kotlin.demo.ui.fragments.FragmentViewTwo
import com.kotlin.demo.ui.utils.inTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //Adding rotation animation to the image
        val rAnim = RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)

        rAnim.duration = 7000
        rAnim.repeatCount = Animation.INFINITE
        rAnim.repeatMode = Animation.RESTART
        rAnim.interpolator = LinearInterpolator()

        waveAnimation();
        img_kotlin.startAnimation(rAnim)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        supportActionBar?.title = ""


    }

    //Wave Animations
    private fun waveAnimation() {
        val screenWidth = getScreenDimensions(this).x
        val waveImgWidth = resources.getDrawable(R.drawable.wave).intrinsicWidth
        var animatedViewWidth = 0
        while (animatedViewWidth < screenWidth) {
            animatedViewWidth += waveImgWidth
        }
        animatedViewWidth += waveImgWidth
        val layoutParams = animated_view.getLayoutParams() as FrameLayout.LayoutParams
        layoutParams.width = animatedViewWidth
        animated_view.setLayoutParams(layoutParams)


        val waveAnimation = TranslateAnimation((-waveImgWidth).toFloat(), 0f, 0f, 0f)
        waveAnimation.interpolator = LinearInterpolator()
        waveAnimation.repeatCount = Animation.INFINITE
        waveAnimation.duration = 2500

        animated_view.startAnimation(waveAnimation)
    }


    fun getScreenDimensions(context: Context): Point {
        val width = context.getResources().getDisplayMetrics().widthPixels
        val height = context.getResources().getDisplayMetrics().heightPixels
        return Point(width, height)
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else if (fragment is FragmentVIewOne) {
            toolbar.title = ""
            //getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            getSupportFragmentManager().popBackStack()


        } else if (fragment is FragmentViewTwo) {
            getSupportFragmentManager().popBackStack()
            toolbar.title = "Fragment One"
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

//NavigationDrawer Onclick Functionality
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.video_view -> {
                val intent = Intent(this, VideoView::class.java)
                startActivity(intent)

            }
            R.id.recycler_card -> {
                val intent = Intent(this, RecyclerAndCardView::class.java)
                startActivity(intent)
            }
            R.id.networking -> {
                val intent = Intent(this, NetworkingView::class.java)
                startActivity(intent)
            }
            R.id.fragment_view -> {
                val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
               if (fragment is FragmentViewTwo) {
                   getSupportFragmentManager().popBackStack()
                }
                else if (!(fragment is FragmentViewTwo)) {
                   supportFragmentManager.inTransaction {
                       replace(R.id.fragment_container, FragmentVIewOne.newInstance())
                   }
                }

            }
            R.id.retrofit_view -> {
                val intent = Intent(this, NetwrokingRetrofitView::class.java)
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
