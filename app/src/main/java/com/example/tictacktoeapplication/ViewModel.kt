package com.example.tictacktoeapplication

//import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.*

class ViewModel : ViewModel() {
    var singlePlayer by mutableStateOf(true)

    var currentPlayer = 1

    var board by mutableStateOf(arrayListOf("", "", "", "", "", "", "", "", ""))

    var isGameOver by mutableStateOf(false)

    var winner by mutableStateOf("")

    var player1 by mutableStateOf("")

    var player2 by mutableStateOf("")


    fun restart() {
        isGameOver = false
        board = arrayListOf("", "", "", "", "", "", "", "", "")
    }
    fun updatePlayerMode(singlePlayer: Boolean) {
        restart()
        this.singlePlayer = singlePlayer
    }

    fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board) {
            if (i != player1 && i != player2) return false
        }
        return true
    }

    fun chooseRandomMove(board: ArrayList<String>, moves: ArrayList<Int>): Int {
        val possibleMoves = arrayListOf<Int>()

        for (i in moves) {
            if (board[i] == "") possibleMoves.add(i)
        }

        return if (possibleMoves.isEmpty()) {
            -1
        } else {
            val index = Random().nextInt(possibleMoves.count())
            possibleMoves[index]
        }
    }

    fun copyBoard(board: ArrayList<String>): ArrayList<String> {
        val newBoard = arrayListOf("", "", "", "", "", "", "", "", "")
        for (i in 0 until board.count()) {
            newBoard[i] = board[i]
        }
        return newBoard
    }

    fun computerMove(board: ArrayList<String>): Int {
        //check if computer can win in this move
        for (i in 0 until board.count()) {
            val copy = copyBoard(board)
            if (copy[i] == "") copy[i] = player2

            //check for win
            if (isGameWon(copy, player2)) return i
        }


        //check if player could win in the next move
        for (i in 0 until board.count()) {
            val copy = copyBoard(board)
            if (copy[i] == "") copy[i] = player1

            if (isGameWon(copy, player1)) return i
        }

        //try to make corners if it is free
        val move = chooseRandomMove(board, arrayListOf(0, 2, 6, 8))
        if (move != -1) return move

        //try to take center if it is free
        if (board[4] == "") return 4

        //finally try to make the sides
        return chooseRandomMove(board, arrayListOf(1, 3, 5, 7))
    }
    fun game(move: Int) {
        if (isGameOver) return

        if (board[move] == "") {
            if (currentPlayer == 1) {
                board = ArrayList(board.toMutableList().also {
                    it[move] = player1
                })
                currentPlayer = 2

                if (singlePlayer) {
                    if (!isBoardFull(board) && !isGameWon(board, player1)) {
                        val nextMove = computerMove(board)

                        board = ArrayList(board.toMutableList().also {
                            it[nextMove] = player2
                        })
                    }
                    currentPlayer = 1
                }
            } else {
                board = ArrayList(board.toMutableList().also {
                    it[move] = player2
                })
                currentPlayer = 1

                if (singlePlayer) {
                    if (!isBoardFull(board) && !isGameWon(board, player2)) {
                        val nextMove = computerMove(board)

                        board = ArrayList(board.toMutableList().also {
                            it[nextMove] = player1
                        })
                    }
                    currentPlayer = 2
                }
            }
        }

        isGameOver = isGameWon(board,player1) || isGameWon(board, player2) || isBoardFull(board)
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
            isGameWon(board, player1) -> "Player 1 won"
            isGameWon(board, player2) -> "Player 2 won"
            isBoardFull(board) -> "It is Tie"
            else -> "Tie"
        }
    }
}
