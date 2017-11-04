package com.ivianuu.viewmodelextensions.sample

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ivianuu.viewmodelextensions.bindViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var factory: ViewModelProviders.DefaultFactory

    private val viewModel by bindViewModel<MainViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
