package cz.mendelu.pef.homework1.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.core.text.isDigitsOnly
import cz.mendelu.pef.homework1.navigation.INavigationRouter


//Na úvodní obrazovce bude jedno textové políčko (TextField) a tlačítko (Button).
// Do tohoto textového políčka uživatel zadá počáteční číslo (Int).
// Pomocí tlačítka přejde na další obrazovku (Obrazovka operace).

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navigation: INavigationRouter) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Calculate")
                })
        },
//    floatingActionButton = {
//        FloatingActionButton(onClick = {
//            navigation.navigateToOperationScreen(10)
//        }) {
//            Text(text = "->")
//
//        }
//    }
    ) {
        LazyColumn(modifier = Modifier.padding(it)){
            item {
                MainScreenContent(navigation)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent(navigation: INavigationRouter) {
//    var text = remember {
//        mutableStateOf("")
//    }
//    TextField(value = text.value,
//        onValueChange = {
//            text.value = it
//        })
//
//    Button(onClick = {
//        // todo prejit na obrazovku Operace
//    }) {
//        Text(text = "Vybrat operaci")
//    }

    // zkopirovano z cv1 TaskListS
    var text = remember {
        mutableStateOf("")
    }

    Column(Modifier.padding(Dp(10F))) {
        OutlinedTextField(value = text.value, onValueChange = {// potreba nastavit i jako promennou, aby se zobrazovala
            text.value = it // jakmile se zmeni hodnota, tak se to zapise do promenne
        })

        OutlinedButton(onClick = {
            if (text.value != "" && text.value.isDigitsOnly()) {
                navigation.navigateToOperationScreen(Integer.parseInt(text.value))
            }
        }) {
            Text(text = "Pocitej")

        }
    }


}