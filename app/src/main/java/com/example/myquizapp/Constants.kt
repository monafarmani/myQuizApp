package com.example.myquizapp

class Constants {

    fun createList():ArrayList<ModelClass>{
        var questionsList = ArrayList<ModelClass>()

        val q1 = ModelClass(1,
            R.drawable.japan,
            "China",
            "Japan",
            "Italy",
            "Korea",
            2)

        questionsList.add(q1)

        val q2 = ModelClass(2,
            R.drawable.denmark,
            "France",
            "Japan",
            "Italy",
            "Denmark",
            4)

        questionsList.add(q2)

        val q3 = ModelClass(3,
            R.drawable.china,
            "China",
            "Korea",
            "Japan",
            "Thailand",
            1)

        questionsList.add(q3)

        val q4 = ModelClass(4,
            R.drawable.italy,
            "China",
            "Japan",
            "Italy",
            "Korea",
            3)

        questionsList.add(q4)

        val q5 = ModelClass(5,
            R.drawable.iraq,
            "Saudi Arabia",
            "Lebanon",
            "Israel",
            "Iraq",
            4)

        questionsList.add(q5)

        val q6 = ModelClass(6,
            R.drawable.israel,
            "Israel",
            "Iraq",
            "Saudi Arabia",
            "Kuwait",
            1)

        questionsList.add(q6)

        val q7 = ModelClass(7,
            R.drawable.southafrica,
            "South Africa",
            "Japan",
            "Egypt",
            "Vietnam",
            1)

        questionsList.add(q7)

        val q8 = ModelClass(8,
            R.drawable.turkey,
            "China",
            "Indonesia",
            "India",
            "Turkey",
            4)

        questionsList.add(q8)

        val q9 = ModelClass(9,
            R.drawable.america,
            "China",
            "Australia",
            "The United States",
            "New Zealand",
            3)

        questionsList.add(q9)

        val q10 = ModelClass(10,
            R.drawable.colombia,
            "Mexico",
            "Peru",
            "Brazil",
            "New Zealand",
            4)

        questionsList.add(q10)


        return questionsList

    }


}