package com.example.myquizapp

class Constants {

    fun normalList():ArrayList<ModelClass>{
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
            R.drawable.indonesia,
            "Mexico",
            "Peru",
            "Monaco",
            "Indonesia",
            4)

        questionsList.add(q10)

        return questionsList
    }


    fun easyList():ArrayList<ModelClass>{
        var questionsList = ArrayList<ModelClass>()

        val q1 = ModelClass(1,
            R.drawable.afghanestan,
            "Iraq",
            "Lebanon",
            "Afghanistan",
            "Korea",
            3)

        questionsList.add(q1)

        val q2 = ModelClass(2,
            R.drawable.australia,
            "Australia",
            "Canada",
            "Austria",
            "England",
            1)

        questionsList.add(q2)

        val q3 = ModelClass(3,
            R.drawable.austria,
            "Sweden",
            "Germany",
            "Japan",
            "Austria",
            4)

        questionsList.add(q3)

        val q4 = ModelClass(4,
            R.drawable.belgium,
            "China",
            "Germany",
            "Belarus",
            "Belgium",
            4)

        questionsList.add(q4)

        val q5 = ModelClass(5,
            R.drawable.brazil,
            "Saudi Arabia",
            "Brazil",
            "India",
            "Russia",
            2)

        questionsList.add(q5)

        val q6 = ModelClass(6,
            R.drawable.canada,
            "Canada",
            "Australia",
            "Greece",
            "Sweden",
            1)

        questionsList.add(q6)

        val q7 = ModelClass(7,
            R.drawable.france,
            "Italy",
            "France",
            "Belgium",
            "Vietnam",
            2)

        questionsList.add(q7)

        val q8 = ModelClass(8,
            R.drawable.greece,
            "Australia",
            "Indonesia",
            "India",
            "Greece",
            4)

        questionsList.add(q8)

        val q9 = ModelClass(9,
            R.drawable.india,
            "China",
            "India",
            "Russia",
            "Colombia",
            2)

        questionsList.add(q9)

        val q10 = ModelClass(10,
            R.drawable.spain,
            "Mexico",
            "Peru",
            "Brazil",
            "Spain",
            4)

        questionsList.add(q10)

        return questionsList
    }


    fun hardList():ArrayList<ModelClass>{
        var questionsList = ArrayList<ModelClass>()

        val q1 = ModelClass(1,
            R.drawable.albania,
            "Bangladesh",
            "Albania",
            "Afghanistan",
            "Belarus",
            2)

        questionsList.add(q1)

        val q2 = ModelClass(2,
            R.drawable.armenia,
            "Armenia",
            "Austria",
            "Belgium",
            "Colombia",
            1)

        questionsList.add(q2)

        val q3 = ModelClass(3,
            R.drawable.bahrain,
            "Cyprus",
            "Egypt",
            "Japan",
            "Bahrain",
            4)

        questionsList.add(q3)

        val q4 = ModelClass(4,
            R.drawable.cuba,
            "Honduras",
            "Israel",
            "Cuba",
            "Belgium",
            3)

        questionsList.add(q4)

        val q5 = ModelClass(5,
            R.drawable.elsalvador,
            "Finland",
            "El Salvador",
            "Honduras",
            "Liberia",
            2)

        questionsList.add(q5)

        val q6 = ModelClass(6,
            R.drawable.fiji,
            "Finland",
            "Australia",
            "Greece",
            "Fiji",
            4)

        questionsList.add(q6)

        val q7 = ModelClass(7,
            R.drawable.georgia,
            "Lebanon",
            "France",
            "Georgia",
            "Vietnam",
            3)

        questionsList.add(q7)

        val q8 = ModelClass(8,
            R.drawable.hungary,
            "Hungary",
            "Indonesia",
            "India",
            "Italy",
            1)

        questionsList.add(q8)

        val q9 = ModelClass(9,
            R.drawable.iceland,
            "Malta",
            "Iceland",
            "New Zealand",
            "Colombia",
            2)

        questionsList.add(q9)

        val q10 = ModelClass(10,
            R.drawable.morocco,
            "Morocco",
            "Monaco",
            "Nepal",
            "Peru",
            1)

        questionsList.add(q10)

        return questionsList
    }
}