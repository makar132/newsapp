package com.example.newsapp.presentaion.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsapp.viewmodels.mainViewmodel

@Composable
fun SearchScreen() {
    /*TODO*/
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val viewmodel: mainViewmodel = viewModel()

        Column {
            val textState by viewmodel.textState.collectAsState()

            val debouncedText by viewmodel.debouncedText.collectAsState(initial = "")
            val brush = remember {
                val rainbowColors = listOf(
                    Color(0xFFff0000), // Red
                    Color(0xFFFF7F00), // Orange
                    Color(0xFFFFff00), // Yellow
                    Color(0xFF00ff00), // Green
                    Color(0xFF0000ff), // Blue
                    Color(0xFF6600ff), // Indigo
                    Color(0xFF8000ff)  // Violet
                )
                Brush.linearGradient(
                    colors = rainbowColors
                )
            }
            TextField(
                value = textState,
                onValueChange =  viewmodel::updateText,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                textStyle = TextStyle(brush = brush)
            )


            Text(text = debouncedText)

        }
    }


}


