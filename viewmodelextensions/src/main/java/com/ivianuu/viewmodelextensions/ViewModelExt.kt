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
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(
    key: String? = null,
    factory: ViewModelProvider.Factory? = null
): T {
    val provider = if (factory != null) {
        ViewModelProviders.of(this, factory)
    } else {
        ViewModelProviders.of(this)
    }

    return if (key != null) {
        provider.get(key, T::class.java)
    } else {
        provider.get(T::class.java)
    }
}

inline fun <reified T : ViewModel> FragmentActivity.bindViewModel(
    key: String? = null,
    factory: ViewModelProvider.Factory? = null
) = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key, factory) }

inline fun <reified T : ViewModel> FragmentActivity.bindViewModel(
    key: String? = null,
    crossinline factory: () -> ViewModelProvider.Factory
) = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key, factory()) }

inline fun <reified T : ViewModel> FragmentActivity.bindViewModel(
    crossinline key: () -> String,
    factory: ViewModelProvider.Factory? = null
) = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key(), factory) }

inline fun <reified T : ViewModel> FragmentActivity.bindViewModel(
    crossinline key: () -> String,
    crossinline factory: () -> ViewModelProvider.Factory
) = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key(), factory()) }

inline fun <reified T : ViewModel> Fragment.getViewModel(
    key: String? = null,
    factory: ViewModelProvider.Factory? = null
): T {
    val viewModelProvider = if (factory != null) {
        ViewModelProviders.of(this, factory)
    } else {
        ViewModelProviders.of(this)
    }

    return if (key != null) {
        viewModelProvider.get(key, T::class.java)
    } else {
        viewModelProvider.get(T::class.java)
    }
}

inline fun <reified T : ViewModel> Fragment.bindViewModel(
    key: String? = null,
    factory: ViewModelProvider.Factory? = null
) = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key, factory) }

inline fun <reified T : ViewModel> Fragment.bindViewModel(
    key: String? = null,
    crossinline factory: () -> ViewModelProvider.Factory
) = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key, factory()) }

inline fun <reified T : ViewModel> Fragment.bindViewModel(
    crossinline key: () -> String,
    factory: ViewModelProvider.Factory? = null
) = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key(), factory) }

inline fun <reified T : ViewModel> Fragment.bindViewModel(
    crossinline key: () -> String,
    crossinline factory: () -> ViewModelProvider.Factory
) = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key(), factory()) }