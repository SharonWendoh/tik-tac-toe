package com.example.tictacktoeapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    var currentPlayer = 1

    var board by mutableStateOf(arrayListOf("", "", "", "", "", "", "", "", ""))

    var isGameOver by mutableStateOf(false)

    var winner by mutableStateOf("")

    fun restart() {
        isGameOver = false
        board = arrayListOf("", "", "", "", "", "", "", "", "")
    }

    fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board) {
            if (i != "X" && i != "O") return false
        }
        return true
    }

    fun game(move: Int) {
        if (isGameOver) return

        if (board[move] == "") {
            if (currentPlayer == 1) {
                board = ArrayList(board.toMutableList().also {
                    it[move] = "X"
                })
                currentPlayer = 2
            } else {
                board = ArrayList(board.toMutableList().also {
                    it[move] = "O"
                })
                currentPlayer = 1
            }
        }

        isGameOver = isGameWon(board,"X") || isGameWon(board, "O") || isBoardFull(board)
        winner = gameOutcome(board)


    }

    fun isGameWon(board: ArrayList<String>, player: String): Boolean =
        if (board[0] == player && board[1] == player && board[2] == player) true
        else if (board[3] == player && board[4] == player && board[5] == player) true
        else if (board[6] == player && board[7] == player && board[8] == player) true
        else if (board[0] == player && board[3] == player && board[6] == player) true
        else if (board[1] == player && board[4] == player && board[7] == player) true
        else if (board[2] == player && board[5] == player && board[8] == player) true
        else if (board[2] == player && board[4] == player && board[6] == player) true
        else board[0] == player && board[4] == player && board[8] == player


    fun gameOutcome(board: ArrayList<String>): String {
        return when {
            isGameWon(board, "X") -> "Player 1 won"
            isGameWon(board, "O") -> "Player 2 won"
            isBoardFull(board) -> "It is Tie"
            else -> "Tie"
        }
    }
}
