package com.radenmas.testing_android_developer.ui.part1.kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.radenmas.testing_android_developer.databinding.ActivityPart1KotlinBinding
import com.radenmas.testing_android_developer.ui.part1.java.MyInterfaceJava
import com.radenmas.testing_android_developer.ui.part1.java.MyServiceJava
import com.radenmas.testing_android_developer.ui.part1.java.MyServiceJava.setInterfaceJava
import com.radenmas.testing_android_developer.ui.part1.kotlin.MyServiceKotlin.MyObjectKotlin.setInterfaceKotlin
import com.radenmas.testing_android_developer.ui.part2.Part2Activity

class Part1ActivityKotlin : AppCompatActivity(), MyInterfaceKotlin, MyInterfaceJava {

    private lateinit var bind: ActivityPart1KotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityPart1KotlinBinding.inflate(layoutInflater)
        setContentView(bind.root)

        initView()
        onClick()
    }

    private fun onClick() {
        bind.btnStartServiceJava.setOnClickListener {
            Intent(this, MyServiceJava::class.java).also {
                startService(it)
                setInterfaceJava(this@Part1ActivityKotlin)
            }
        }

        bind.btnStartServiceKotlin.setOnClickListener {
            Intent(this, MyServiceKotlin::class.java).also {
                startService(it)
                setInterfaceKotlin(this@Part1ActivityKotlin)
            }
        }

        bind.btnMoveToPart2.setOnClickListener {
            Intent(this, Part2Activity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun initView() {
        bind.tvStatusService.text = "Service stopped"
    }

    override fun callBackKotlin(data: String) {
        bind.tvStatusService.text = data
    }

    override fun callBackJava(data: String?) {
        bind.tvStatusService.text = data
    }

}