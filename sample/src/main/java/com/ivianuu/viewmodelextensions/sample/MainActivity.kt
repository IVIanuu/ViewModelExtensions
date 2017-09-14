package com.ivianuu.viewmodelextensions.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ivianuu.viewmodelextensions.bindViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by bindViewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
