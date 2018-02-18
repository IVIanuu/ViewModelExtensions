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

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(): T =
    ViewModelProviders.of(this)[T::class.java]

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(
    factory: ViewModelProvider.Factory
): T = ViewModelProviders.of(this, factory)[T::class.java]

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(
    key: String
): T = ViewModelProviders.of(this)[key, T::class.java]

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(
    key: String,
    factory: ViewModelProvider.Factory
): T = ViewModelProviders.of(this, factory).get(key, T::class.java)

inline fun <reified T: ViewModel> FragmentActivity.bindViewModel(): Lazy<T> =
        lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>() }

inline fun <reified T: ViewModel> FragmentActivity.bindViewModel(
    crossinline factory: () -> ViewModelProvider.Factory
): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(factory()) }

inline fun <reified T: ViewModel> FragmentActivity.bindViewModel(
    key: String
): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { getViewModel<T>(key) }