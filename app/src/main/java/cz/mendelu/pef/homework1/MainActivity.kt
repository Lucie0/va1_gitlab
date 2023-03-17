package cz.mendelu.pef.homework1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import cz.mendelu.pef.homework1.navigation.Destination
import cz.mendelu.pef.homework1.navigation.NavGraph
import cz.mendelu.pef.homework1.ui.screens.MainScreen
import cz.mendelu.pef.homework1.ui.theme.Homework1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Homework1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Text("Android")
//                    MainScreen(navigation)
                    NavGraph(startDestination = Destination.MainScreen.route)
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Homework1Theme {
//        Greeting("Android")
//    }
//}