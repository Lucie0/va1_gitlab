package cz.mendelu.pef.homework1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.mendelu.pef.homework1.navigation.INavigationRouter
import cz.mendelu.pef.homework1.ui.elements.BackArrowScreen
import cz.mendelu.pef.homework1.ui.elements.Operators

//Do obrazovky operace je předáno číslo z úvodní obrazovky. 
// Obrazovka operace obsahuje 4 tlačítka: sčítání, odčítání, násobení a dělení. 
// Po stisku tlačítka přechází uživatel na další
//obrazovku (Výsledková obrazovka). Do výsledkové 
// obrazovky je předána hodnota a
//operace. Pro operaci použijte například datový 
// typ String.

@Composable
fun OperationScreen(
    navigation: INavigationRouter, 
    num: Int?) {
    BackArrowScreen(
        appBarTitle = "Operation", 
        onBackClick = {
            navigation.navigateBack()        
    }) {
        OperationScreenContent(it, navigation, num)
    }
}

@Composable
fun OperationScreenContent(paddingValues: PaddingValues,
                           navigation: INavigationRouter,
                           num: Int?){
    Row(modifier = Modifier.fillMaxWidth().padding(paddingValues), // todo okraje vnejsi
        horizontalArrangement = Arrangement.SpaceBetween){
        Button(onClick = {
//            navigation.navigateToResultScreen(Operators.ADDITION, num) // (druhy operand je 3)
            navigation.navigateToResultScreen("ADD", num) // (druhy operand je 3)
        }) {
            Text(text = "+")
        }
        Button(onClick = {
//            navigation.navigateToResultScreen(Operators.SUBTRACTION, num)
        }) {
            Text(text = "-")
        }
        Button(onClick = {
//            navigation.navigateToResultScreen(Operators.MULTIPLICATION, num)
        }) {
            Text(text = "*")
        }
        Button(onClick = {
//            navigation.navigateToResultScreen(Operators.DIVISION, num)
        }) {
            Text(text = "/")
        }
    }


}
