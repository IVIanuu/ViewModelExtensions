package com.ivianuu.viewmodelextensions.sample

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ivianuu.viewmodelextensions.bindViewModel
import com.ivianuu.viewmodelextensions.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var factory: ViewModelProvider.Factory

    private val viewModel by bindViewModel<MainViewModel> { factory }

    private val viewMode by lazy { getViewModel<ViewModel>("key", factory) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
