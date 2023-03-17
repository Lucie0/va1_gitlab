package cz.mendelu.pef.homework1.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cz.mendelu.pef.homework1.navigation.INavigationRouter
import cz.mendelu.pef.homework1.ui.elements.BackArrowScreen
import cz.mendelu.pef.homework1.ui.elements.Operators

@Composable
fun ResultScreen(
    navigation: INavigationRouter,
    operator: Operators,
    num: Int?
){
    var result: Int = 0
    BackArrowScreen(
        appBarTitle = "Results",
        onBackClick = {
            navigation.navigateBack()
    }) {
        when(operator){
            Operators.ADDITION -> {
                result = num?.plus(3) ?: 3
            }
            Operators.SUBTRACTION -> TODO()
            Operators.MULTIPLICATION -> TODO()
            Operators.DIVISION -> TODO()
        }
        ResultScreenContent(result)
    }
}

@Composable
fun ResultScreenContent(result: Int){
    Text(text = "Result")

    Text(text = "$result")
}