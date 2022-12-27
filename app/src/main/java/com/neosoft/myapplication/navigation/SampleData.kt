package com.neosoft.myapplication.navigation

import androidx.lifecycle.MutableLiveData

class SampleData {
    companion object{
        var defaultValue = MutableLiveData<Long>(100L)
    }
}