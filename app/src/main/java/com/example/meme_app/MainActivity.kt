package com.example.meme_app

import android.net.http.HttpException
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

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
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Meme_AppTheme {
                val navController = rememberNavController()
                val memeList by remember{
                    mutableStateOf(listOf<Meme>())

                }
                val scope = rememberCoroutineScope()
                LaunchedEffect(key1 = true)
                {
                    scope.launch(Dispatchers.IO) {
                        val response = try
                        {
                            Retrofit_Instance.api.getALLMemesList()
                        }catch (e:IOException)
                        {
                            Toast.makeText(this@MainActivity,"APP ERROR",Toast.LENGTH_LONG).show()
                            return@launch
                        }catch (e:HttpException)
                        {
                            Toast.makeText(this@MainActivity,"request ERROR",Toast.LENGTH_LONG).show()
                            return@launch
                        }
                    }
                }



                NavHost(navController = navController, startDestination = "MainScreen" )
                {
                    composable(route= "MainScreen")
                    {
                        MainScreen()
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


