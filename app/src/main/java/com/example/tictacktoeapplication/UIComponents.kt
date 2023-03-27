package com.example.tictacktoeapplication

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SwitchButton(checked: Boolean, modifier: Modifier = Modifier, onCheckedChange:(isChecked: Boolean) -> Unit) {
    Switch(
        checked = checked,
        modifier = modifier,
        onCheckedChange = { newChecked -> onCheckedChange(newChecked)

        }
    )
}

@Composable
fun button(text: String, onclick: () -> Unit){
    Button(onClick = onclick,
        modifier = Modifier
            .background(color = MaterialTheme.colors.primaryVariant)
            .size(100.dp, 100.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Red
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            ),

        )
    }
}

@Composable
fun RestartButton(onclick: () -> Unit){
    Button(
        onClick = onclick,
        modifier = Modifier
            .size(300.dp,50.dp),

    ) {
        Text(text =  "Restart Game")
    }
}

@Composable
fun Screen(board: ArrayList<String>, onclick: (Int) -> Unit){
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center) {
        Column(


        ) {
            Row(
                modifier = Modifier
            ) {
                button(text = board[0]) { onclick(0) }
                Spacer(modifier = Modifier.size(5.dp))
                button(text = board[1]) { onclick(1) }
                Spacer(modifier = Modifier.size(5.dp))
                button(text = board[2]) { onclick(2) }
            }
            Spacer(modifier = Modifier.size(5.dp))
            Row {
                button(text = board[3]) { onclick(3) }
                Spacer(modifier = Modifier.size(5.dp))
                button(text = board[4]) { onclick(4) }
                Spacer(modifier = Modifier.size(5.dp))
                button(text = board[5]) { onclick(5) }
            }
            Spacer(modifier = Modifier.size(5.dp))
            Row {
                button(text = board[6]) { onclick(6) }
                Spacer(modifier = Modifier.size(5.dp))
                button(text = board[7]) { onclick(7) }
                Spacer(modifier = Modifier.size(5.dp))
                button(text = board[8]) { onclick(8) }
            }
            Spacer(modifier = Modifier.size(40.dp))

        }
    }
}

//@Preview
//@Composable
//fun previewScreen(){
//    Screen(arrayListOf("", "", "", "", "", "", "", "", ""),onclick = {})
//}
//
//
//@Preview
//@Composable
//fun previewButton(){
//    button("X", onclick = {})
//}