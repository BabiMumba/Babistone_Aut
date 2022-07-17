package com.example.babistone_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_onboarding.*

class Onboarding : AppCompatActivity() {
    private lateinit var onboardingAdapter: OnBoarding_Adapter
    lateinit var indicator_background :LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        setOnboardingItems()
        setupIndicators()
        setcurrentindicators(0)


    }
    private fun setOnboardingItems(){
        onboardingAdapter = OnBoarding_Adapter(
            listOf(
                OnBoardind_items(R.drawable.smartphone,
                "bonjour",
                    "juste une pub merci"
                    ),
                        OnBoardind_items(R.drawable.message,
                "salutation",
                "jespert que vous allez bien"
            ),
                OnBoardind_items(R.drawable.smartphone,
                    "very nice",
                    "oo[ps encore de la pub"
                )
            )
        )
        val onBoardingViwpager = findViewById<ViewPager2>(R.id.onboarding_page2)
        onBoardingViwpager.adapter = onboardingAdapter
        onBoardingViwpager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setcurrentindicators(position)
            }
        })
        (onBoardingViwpager.getChildAt(0)as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }
    private fun setupIndicators(){
        indicator_background = findViewById(R.id.indicator_containers)
        val indicators = arrayOfNulls<ImageView>(onboardingAdapter.itemCount)
        val layoutparams:LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT,
            WRAP_CONTENT)
        layoutparams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let{
                it.setImageDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.indicator_inactive_background))
                it.layoutParams = layoutparams
                indicator_containers.addView(it)
            }
        }
    }
    private fun setcurrentindicators(position:Int){
        val childcount = indicator_containers.childCount
        for (i in 0 until childcount){
            val imageView = indicator_containers.getChildAt(i) as ImageView
            if (i == position){
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.indication_active_background))
            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.indicator_inactive_background))
            }
        }
    }

}