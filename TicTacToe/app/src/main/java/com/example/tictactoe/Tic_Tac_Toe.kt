package com.example.tictactoe

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Tic_Tac_Toe : AppCompatActivity() {

    private var playerOneTurn = true;
    private  var playerOneMoves = mutableListOf<Int>()
    private var playerTwoMoves = mutableListOf<Int>()

    private val possibleWins: Array<List<Int>> = arrayOf(
        //horizontal lines
        listOf(1,2,3),
        listOf(4,5,6),
        listOf(7,8,9),

        //vertical lines
        listOf(1,4,7),
        listOf(2,5,8),
        listOf(3,6,7),

        //diagonal lines
        listOf(1,5,9),
        listOf(3,5,7)

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)
        setupBoard()//setting up the box dynamically

    }


     private fun setupBoard(){
         val Board = findViewById<LinearLayout>(R.id.board)
         var counter = 1; // this get incremented whenever we add a button

         //parameter for each of the View

         //param1 parameter width is MATCH_PARENT and height is 0
         val params1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT , 0)
         //params2 parameter width is 0 and height is MATCH_PARENT
         val params2 = LinearLayout.LayoutParams(0 , LinearLayout.LayoutParams.MATCH_PARENT)

         //we have to add three linear layout so we are using loop
         for(i in 1..3){
             val linearLayout = LinearLayout(this)
             linearLayout.orientation = LinearLayout.HORIZONTAL

             //creating a LinearLayout whose orientation is Horizontal
             linearLayout.layoutParams = params1 //assigning the layout parameter as param1 type
             params1.weight = 1.0F // using this all 3(vertical) linear layout will be set in size

             //Now inside that (horizontal) Linear Layout we are inserting our 3 buttons
             for(j in 1..3){
                 val button = Button(this)
                 button.id = counter // set the ID as counter
                 button.textSize = 42.0F
                 //setting the text colour
                 button.setTextColor(ContextCompat.getColor(this, R.color.purple_200))

                 button.layoutParams = params2 // set its layout params
                 params2.weight = 1.0F

                 button.setOnClickListener{
                     recordMove(it)
                 }
                 linearLayout.addView(button) // adding the button to the LinearLayout
                 counter++;
             }
             //after that this linerLayout get added into the board
             Board.addView(linearLayout)
         }
     }

    //In recordMove we pass the button which is clicked
    private fun recordMove(view: View){ // here view is a button
        val playerOne = findViewById<EditText>(R.id.player_one)
        val playerTwo = findViewById<EditText>(R.id.player_two)
        val playerOneLabel = findViewById<TextView>(R.id.player_one_label)
        val playerTwoLabel = findViewById<TextView>(R.id.player_two_label)

        val button = view as Button // we know the view is button so cast it as Button
        val id = button.id // get its ID

        //first we check whether its playerOneTurn or not
        if(playerOneTurn){
            playerOneMoves.add(id) // we add ID to layer one moves

            button.text = "O" // set its text
            button.isEnabled = false //then we have disabled that bcz ones we have used that button we cannot click it again

            //here w call the checkWin() function and pass all the moves
            if(checkWin(playerOneMoves)){
                showWinMessage(playerOne)
            }
            else{
                playerOneTurn = false
                togglePlayerTurn(playerTwoLabel , playerOneLabel)
            }
        }
        
        else{
            playerTwoMoves.add(id)
            
            button.text = "X"
            button.isEnabled =false
            if(checkWin(playerTwoMoves)){
                showWinMessage(playerTwo)
            }else{
                playerOneTurn = true
                togglePlayerTurn(playerOneLabel , playerTwoLabel)
            }
        }
    }

      // here we are besically setting the text colour
    private fun togglePlayerTurn(playerOn: TextView, playerOff: TextView) {
        playerOff.setTextColor(ContextCompat.getColor(this, R.color.black))
        playerOff.setTypeface(null , Typeface.NORMAL)

        playerOn.setTextColor(ContextCompat.getColor(this, R.color.purple_200))
        playerOn.setTypeface(null, Typeface.BOLD)

    }

    private fun checkWin(moves: List<Int>): Boolean {
        var won = false
        if(moves.size >= 3){
            run loop@{
                possibleWins.forEach {
                    if(moves.containsAll(it)){
                        won = true
                        return@loop
                    }
                }
            }
        }
        return won

    }

    private fun showWinMessage(player: EditText){
        var playerName = player.text.toString()
        if(playerName.isBlank()){
            playerName = player.hint.toString()
        }
        Toast.makeText(this, "Congratulations! $playerName You Won", Toast.LENGTH_SHORT).show()

    }
}