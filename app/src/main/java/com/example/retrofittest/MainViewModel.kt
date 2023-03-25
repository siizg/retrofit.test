package com.example.retrofittest

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var movieList : List<Movie> by mutableStateOf(listOf())
    var errorMessage : String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movieListNew = apiService.getMovies()
                movieList = movieListNew
            }
            catch (e : Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}