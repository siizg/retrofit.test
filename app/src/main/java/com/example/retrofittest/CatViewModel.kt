package com.example.retrofittest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {
    var fact : Cat by mutableStateOf(Cat(""))
    fun getFact() {
        viewModelScope.launch {
            val apiService = ApiServiceCat.getInstance()
            try {
                val newFact = apiService.getCatFact()
                fact = newFact
            }
            catch (e : Exception) {
                
            }

        }
    }
}