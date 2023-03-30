package com.example.tictacktoeapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictacktoeapplication.ui.theme.TicTackToeApplicationTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ViewModel>()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTackToeApplicationTheme {
                Scaffold(
                    topBar = {
                        AppBar(checked = viewModel.singlePlayer, onCheckedChange = {newChecked ->
                            if(viewModel.singlePlayer){
                                viewModel.updatePlayerMode(false)
                            }else{
                                viewModel.updatePlayerMode(true)
                            }
                        }
                        )
                    }
                ){
                    Surface(color = MaterialTheme.colors.background) {
                        PaddingValues(0.dp)

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = MaterialTheme.colors.primary),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CharTextField ("Enter Player1 Character"){ text ->
                                viewModel.player1 = text
                                Log.d("MainActivity", "Text entered: $text")
                            }
                            Spacer(modifier = Modifier.size(5.dp))
                            CharTextField ("Enter Player2 Character") { text ->
                                viewModel.player2 = text
                                Log.d("MainActivity", "Text entered: $text")
                            }
                            Spacer(modifier = Modifier.size(10.dp))

                            Screen(board = viewModel.board,viewModel::game)
                            Spacer(modifier = Modifier.size(25.dp))

                            if (viewModel.isGameOver) {
                                Box(contentAlignment = Alignment.TopCenter) {
                                    Text(
                                        text = "Game is Over: ${viewModel.winner}",
                                        fontSize = 20.sp,
                                        color = Color.White
                                    )
                                }
                            }
                            RestartButton(onclick = viewModel::restart)
                        }
                    }
                }

            }
        }
    }
}

