package cz.mendelu.pef.midterm2

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
import cz.mendelu.pef.midterm2.navigation.Destination
import cz.mendelu.pef.midterm2.navigation.NavGraph
import cz.mendelu.pef.midterm2.ui.screens.PlayersListScreen
import cz.mendelu.pef.midterm2.ui.theme.Midterm2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Midterm2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    PlayersListScreen(navigation)
//                    AddPlayerScreen()
                    NavGraph(startDestination = Destination.PlayersListScreen.route)
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
    Midterm2Theme {
        Greeting("Android")
    }
}