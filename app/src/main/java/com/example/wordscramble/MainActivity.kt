package com.example.wordscramble

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wordscramble.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newGame()
    }

    private fun newGame() {
        binding.editWord.text?.clear()
        val selectedWord = resources.getStringArray(R.array.words).random()
        val mixedWord = selectedWord.toCharArray().let {
            it.shuffle()
            it.concatToString()
        }
        binding.scrambledText.text = mixedWord

        binding.buttonUnscramble.setOnClickListener {
            val userWord: String = binding.editWord.text.toString()
            if (userWord != "") {
                if (selectedWord.equals(userWord)) {
                    Toast.makeText(this, "You are right !! :)", Toast.LENGTH_SHORT).show()
                    newGame()
                } else Toast.makeText(this, "You are wrong !! :(", Toast.LENGTH_SHORT).show()
            }
        }
    }
}