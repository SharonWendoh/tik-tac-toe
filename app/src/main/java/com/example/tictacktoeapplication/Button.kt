package com.example.tictacktoeapplication

import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun button(){
    Button(onClick = {},
        modifier = Modifier
            .background(color = MaterialTheme.colors.primaryVariant)
    ) {

    }
}

@Preview
@Composable
fun previewButton(){
    button()
}