package cz.mendelu.pef.dostihyasazky

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
import cz.mendelu.pef.dostihyasazky.navigation.Destination
import cz.mendelu.pef.dostihyasazky.navigation.NavGraph
import cz.mendelu.pef.dostihyasazky.ui.screens.RulesScreen
import cz.mendelu.pef.dostihyasazky.ui.screens.my_cards.MyCardsScreen
import cz.mendelu.pef.dostihyasazky.ui.screens.my_cards.MyCardsScreenContent
import cz.mendelu.pef.dostihyasazky.ui.theme.DostihyASazkyTheme

// todo jak vlozit obrazek,

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DostihyASazkyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MainScreen()
//                    MyCardsScreen()
//                    CardDetailScreen()
//                    SavedGamesListScreen()
//                    TransactionsHistoryScreen()
                    NavGraph(startDestination = Destination.MainScreen.route)

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
    DostihyASazkyTheme {
        Greeting("Android")
    }
}