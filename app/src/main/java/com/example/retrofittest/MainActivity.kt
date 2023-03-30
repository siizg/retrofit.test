package com.example.retrofittest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofittest.ui.theme.RetrofittestTheme

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofittestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    mainViewModel.getFact()
                    Fact(fact = mainViewModel.fact)

                }
            }
        }
    }
}

@Composable
fun Fact( fact : Cat) {
    Text(fact.fact)
}

@Composable
fun MovieItem(movie: Movie) {
    Card(modifier = Modifier
        .padding(8.dp, 4.dp)
        .fillMaxWidth()
        .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp) {

        Row(
            modifier =
            Modifier
                .padding(4.dp)
                .fillMaxSize()) {
            Column(modifier = Modifier
                .padding(4.dp)
                .fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Text(text = movie.name, style = MaterialTheme.typography.h1, fontWeight = FontWeight.Bold)
                Text(
                    text = movie.category,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .background(
                            Color.LightGray
                        )
                        .padding(4.dp)
                )
                Text(
                    text = movie.desc,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            MovieItem(movie = item)
        }
    }
}