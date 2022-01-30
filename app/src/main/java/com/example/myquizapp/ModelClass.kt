package com.example.myquizapp

import java.lang.Enum

data class ModelClass(

    var id: Int,
    var image: Int,
    var optionOne: String,
    var optionTwo: String,
    var optionThree: String,
    var optionFour: String,
    var correctAnswer: Int

)

enum class LevelQuiz {
    EASY, NORMAL, HARD;

     fun toLevelQuiz(levelQuizString: String?): LevelQuiz? {
        return try {
            levelQuizString?.let { LevelQuiz.valueOf(it) }
        } catch (ex: Exception) {
            // For error cases
            EASY
        }
    }
}