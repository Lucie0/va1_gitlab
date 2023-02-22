package cz.mendelu.pef.cv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cz.mendelu.pef.cv1.ui.screens.AddEditTaskScreen
import cz.mendelu.pef.cv1.ui.screens.MapScreen
import cz.mendelu.pef.cv1.ui.screens.TaskListScreen
import cz.mendelu.pef.cv1.ui.theme.Cv1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            // by remember: ze si ji ma pamatovat; ulozi si ji do pameti,
//            // mutableStateOf: pocitej s tim, ze se hodnota bude menit a neprepisuj ji na inicializacni hodnotu
//            var counter by remember { mutableStateOf(0) }

            Cv1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), 
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskListScreen()

////                    Greeting("Android")
//                    Column(/*parametry, jestli ma byt roztazeny po cele delce apod.*/) {
//                        Text(text = "Vysledek $counter")
//                        Button(onClick = {
//                            // udalost, kdyz se na tlacitko klikne
//                            counter++
//
//                        }) { // reprezentace, co je uvnitr tlacitka
//                            Text(text = getString(R.string.add)) // exportovani stringu do strings.xml -- vygeneruje se tento retezec
//                        }
//                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Cv1Theme {
//        Greeting("Android")
//    }
//}