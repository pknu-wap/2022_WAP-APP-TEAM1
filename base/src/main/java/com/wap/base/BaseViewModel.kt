package com.wap.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wap.base.provider.DispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel(private val dispatcherProvider: DispatcherProvider): ViewModel(), DispatcherProvider by dispatcherProvider {

    inline fun onMain(crossinline body: suspend CoroutineScope.() -> Unit) = viewModelScope.launch(main) {
        body(this)
    }

    inline fun onIo(crossinline body: suspend CoroutineScope.() -> Unit) = viewModelScope.launch(io) {
        body(this)
    }

    inline fun onDefault(crossinline body: suspend CoroutineScope.() -> Unit) = viewModelScope.launch(default) {
        body(this)
    }
}