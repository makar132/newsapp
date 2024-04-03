package com.example.newsapp.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.newsapp.presentaion.ui.screens.TabItem
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce

class mainViewmodel : ViewModel() {

    private var _selectedTab = mutableStateOf(TabItem.MainTap)
    val selectedTab: TabItem
        get() = _selectedTab.value

    private val _textState = MutableStateFlow("")
    val textState = _textState.asStateFlow()

    @OptIn(FlowPreview::class)
    val debouncedText = textState.debounce(1000)

    val showText = mutableStateOf(false)

    fun updateSelectedTab(newTabItem: TabItem) {
        _selectedTab.value = newTabItem
    }

    fun updateText(text: String) {
        _textState.value = text
    }
}