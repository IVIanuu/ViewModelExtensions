/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.viewmodelextensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity

/**
 * Returns the viewmodel
 */
inline fun <reified T : ViewModel> FragmentActivity.getViewModel(factory: ViewModelProvider.Factory? = null,
                                                                 key: String? = null) : T {
    val viewModelProvider = if (factory != null) {
        ViewModelProviders.of(this, factory)
    } else{
        ViewModelProviders.of(this)
    }

    return if (key != null) {
        viewModelProvider.get(key, T::class.java)
    } else{
        viewModelProvider.get(T::class.java)
    }
}

/**
 * Lazily binds the view model
 */
inline fun <reified T : ViewModel> FragmentActivity.bindViewModel(factory: ViewModelProvider.Factory? = null,
                                                                  key: String? = null) : Lazy<T> {
    return lazy { getViewModel<T>(factory, key) }
}

/**
 * Lazily binds the view model
 * This method is useful if your factory is a late init var
 */
inline fun <reified T : ViewModel> FragmentActivity.bindViewModel(crossinline factoryProvider: () ->  ViewModelProvider.Factory,
                                                                  key: String? = null) : Lazy<T> {
    return lazy { getViewModel<T>(factoryProvider.invoke(), key) }
}