package com.example.tictacktoeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictacktoeapplication.ui.theme.TicTackToeApplicationTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTackToeApplicationTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CharTextField { text ->
                        viewModel.player1 = text
                        Log.d("MainActivity", "Text entered: $text")
                    }
                    CharTextField { text ->
                        viewModel.player2 = text
                        Log.d("MainActivity", "Text entered: $text")
                    }
                    Row() {
                        Text(text = "Single Player")
                        Spacer(modifier = Modifier.size(10.dp))
                        SwitchButton(checked = viewModel.singlePlayer, onCheckedChange = {newChecked ->
                            if(viewModel.singlePlayer){
                                viewModel.updatePlayerMode(false)
                            }else{
                                viewModel.updatePlayerMode(true)
                            }
                        }
                        )
                    }
                    Screen(board = viewModel.board,viewModel::game)
                    Spacer(modifier = Modifier.size(30.dp))
                    if (viewModel.isGameOver) {
                        Box(contentAlignment = Alignment.TopCenter) {
                            Text(
                                text = "Game is Over: ${viewModel.winner}",
                                fontSize = 20.sp
                            )
                        }
                    }
                    RestartButton(onclick = viewModel::restart)
                }
            }
        }
    }
}

