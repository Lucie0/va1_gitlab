package cz.mendelu.pef.app_test_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cz.mendelu.pef.app_test_1.navigation.Destination
import cz.mendelu.pef.app_test_1.navigation.NavGraph
import cz.mendelu.pef.app_test_1.ui.screens.AddCarScreen
import cz.mendelu.pef.app_test_1.ui.theme.App_test_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_test_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    CarListScreen()
//                    AddCarScreen(navigation)
                    NavGraph(startDestination = Destination.CarListScreen.route)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App_test_1Theme {
        Greeting("Android")
    }
}