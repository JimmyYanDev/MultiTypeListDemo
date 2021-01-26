package com.fadebad.multitypelistdemo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fadebad.multitypelistdemo.logic.main.model.ShortCut

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val list = MutableLiveData<List<ShortCut>>()

    fun getShortCuts(): MutableLiveData<List<ShortCut>> {

        return list;
    }
}