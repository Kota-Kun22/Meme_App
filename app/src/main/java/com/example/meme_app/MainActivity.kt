package com.example.meme_app

import android.net.http.HttpException
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meme_app.Models.Meme
import com.example.meme_app.Screens.DetailsScreen
import com.example.meme_app.Screens.MainScreen
import com.example.meme_app.Utils.Retrofit_Instance
import com.example.meme_app.ui.theme.Meme_AppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Meme_AppTheme {
                val navController = rememberNavController()
                var memeList by remember{
                    mutableStateOf(listOf<Meme>())

                }
                val scope = rememberCoroutineScope()

                LaunchedEffect(key1 = true){ scope.launch(Dispatchers.IO)
                {
                        val response = try {
                            Retrofit_Instance.api.getALLMemesList()
                        }catch (e: IOException){

                            Toast.makeText(this@MainActivity, "app error: ${e.message}", Toast.LENGTH_SHORT).show()

                            return@launch
                        }catch (e : HttpException){

                            Toast.makeText(this@MainActivity, "HTTP error: ${e.message}", Toast.LENGTH_SHORT).show()

                            return@launch
                        }
                        if (response.isSuccessful && response.body() != null){
                            withContext(Dispatchers.Main){
                                memeList = response.body()!!.data.memes
                            }
                        }
                    }
                }



                NavHost(navController = navController, startDestination = "MainScreen" )
                {
                    composable(route= "MainScreen")
                    {
                        MainScreen(memeList= memeList, navController= navController)
                    }

                    composable(route="DetailsScreen")
                    {
                        DetailsScreen()
                    }
                }
            }
        }
    }
}


