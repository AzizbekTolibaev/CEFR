package com.imax.cefr.data.models

enum class TextType(val code: Int){
    TITLE(0), NORMAL(1), EXAMPlE(2)
}



data class ExampleData(
    val textType: TextType,
    val body: String
)
