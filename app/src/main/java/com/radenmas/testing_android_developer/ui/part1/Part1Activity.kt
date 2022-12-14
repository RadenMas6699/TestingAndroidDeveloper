package com.radenmas.testing_android_developer.ui.part1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.testing_android_developer.databinding.ActivityPart1Binding
import com.radenmas.testing_android_developer.ui.part2.Part2Activity

class Part1Activity : AppCompatActivity() {

    private lateinit var bind: ActivityPart1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityPart1Binding.inflate(layoutInflater)
        setContentView(bind.root)

        initView()
        onClick()
    }

    private fun onClick() {
        bind.btnStartService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                bind.tvStatusService.text = "Service running"
            }
        }
        bind.btnMoveToPart2.setOnClickListener {
            Intent(this, Part2Activity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun initView() {

    }


}