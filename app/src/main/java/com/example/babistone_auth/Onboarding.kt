package com.example.babistone_auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
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
                OnBoardind_items(R.drawable.download,
                "telecharger",
                    "telecharger tous vos livre preferer"
                    ),
                        OnBoardind_items(R.drawable.education_book,
                "Livre sur l'education",
                "retrouver tous vos sur l'education"
            ),
                OnBoardind_items(R.drawable.finance_book,
                    "Livre sur la finance",
                    "le livre sur la finace sont a votre portee"
                ),
                OnBoardind_items(R.drawable.girl_book,
                    "liser en format pdf",
                    "retrouver le meilleur lecteur pdf sur l'application stone book"
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
        findViewById<ImageView>(R.id.image_next).setOnClickListener {
            if (onBoardingViwpager.currentItem+1 < onboardingAdapter.itemCount){
                onBoardingViwpager.currentItem += 1
            }else{
                navigationTohomeActivity()
            }
        }
        findViewById<TextView>(R.id.text_skip).setOnClickListener {
            navigationTohomeActivity()
        }
        findViewById<MaterialButton>(R.id.btn_get_start).setOnClickListener {
            navigationTohomeActivity()
        }
    }
    private fun navigationTohomeActivity(){
        startActivity(Intent(applicationContext,Home_pageActivity::class.java))
        finish()
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