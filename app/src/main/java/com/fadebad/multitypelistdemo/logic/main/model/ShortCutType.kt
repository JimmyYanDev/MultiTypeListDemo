package com.fadebad.multitypelistdemo.logic.main.model

sealed class ShortCutType(val type: Int){

}

class TitleView(type: Int) : ShortCutType(type)

