package com.eeearl.mnm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.eeearl.mnm.ui.main.MainScreen
import com.eeearl.mnm.ui.theme.NowTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {

                    }
                    MainScreen()
//                    val viewModel = koinViewModel<TopViewModel>()
//                    val scope = rememberCoroutineScope()
//                    var text by remember { mutableStateOf("Loading") }
//                    LaunchedEffect(true) {
//                        scope.launch {
//                            text = try {
//                                viewModel.getTopList().toString()
//                            } catch (e: Throwable) {
//                                e.localizedMessage ?: "Error"
//                            }
//                        }
//                    }
//                    Text(text = text)
                }
            }
        }
    }
}
