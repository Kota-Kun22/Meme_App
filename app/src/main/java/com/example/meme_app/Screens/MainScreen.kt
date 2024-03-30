package com.example.meme_app.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.meme_app.Models.Meme

@Composable
fun MainScreen(modifier: Modifier = Modifier, memeList: List<Meme>, navController: NavHostController)
{
    Column(modifier.fillMaxSize()) {
        val textState = remember{
            mutableStateOf(TextFieldValue(""))
        }

        SearchView(state=textState, placeholder= "Search here..", modifier=modifier)

        val searchedText =  textState.value.text
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp)
        ){
            

        }
    }

}
@Composable
fun SearchView(state: MutableState<TextFieldValue>, placeholder: String, modifier: Modifier)
{

}