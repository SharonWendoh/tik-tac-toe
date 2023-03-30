package com.example.tictacktoeapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AppBar(checked: Boolean, onCheckedChange:(isChecked: Boolean) -> Unit) {
    TopAppBar(
        title = { Text(text = "Tic Tac Toe", color = Color.White) },
        actions = {
            Row(modifier = Modifier.padding(end = 16.dp)) {
                Text(
                    text = "Single Player",
                    color = Color.White)
                Spacer(modifier = Modifier.size(10.dp))
                Switch(
                    checked = checked,
                    onCheckedChange = { newChecked -> onCheckedChange(newChecked)
                    }
                )
            }
        }
    )
}

@Composable
fun CharTextField(placeholder: String,onTextChange: (String) -> Unit){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.primary,
            textColor = MaterialTheme.colors.primaryVariant),
        modifier =Modifier
            .border(BorderStroke(2.dp,Color.White), shape = CircleShape)
            .clip(CircleShape)
            .padding(4.dp),

        placeholder = {
            Row(
                horizontalArrangement = Arrangement.Start
            ) {
                Text (
                    text = placeholder,
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = 15.sp
                    //style = MaterialTheme.typography.h1

                )
            }

        },
        onValueChange = { newText ->
            text = newText
            onTextChange(newText.text)
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
            backgroundColor = MaterialTheme.colors.primaryVariant
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            ),
            color = MaterialTheme.colors.primary

        )
    }
}

@Composable
fun RestartButton(onclick: () -> Unit){
    Button(
        onClick = onclick,
        modifier = Modifier
            .size(300.dp,50.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primaryVariant
        )

    ) {
        Text(
            text =  "Restart Game ",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        )
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
//fun previewCharTextField(){
//    CharTextField()
//}
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