package com.example.tictacktoeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tictacktoeapplication.ui.theme.TicTackToeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTackToeApplicationTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxHeight()) {
                    Column() {
                        Row {
                            button()
                            button()
                            button()
                        }
                        Row {
                            button()
                            button()
                            button()
                        }
                        Row {
                            button()
                            button()
                            button()
                        }
                    }
                }
            }
        }
    }
}

