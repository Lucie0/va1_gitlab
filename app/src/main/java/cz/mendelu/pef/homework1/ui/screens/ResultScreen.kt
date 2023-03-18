package cz.mendelu.pef.homework1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import cz.mendelu.pef.homework1.navigation.INavigationRouter
import cz.mendelu.pef.homework1.ui.elements.BackArrowScreen

@Composable
fun ResultScreen(
    navigation: INavigationRouter,
    operator: String?,
    num: Int?
){
    val secondOperand = 3
    var result: Int = 0

    BackArrowScreen(
        appBarTitle = "Results",
        onBackClick = {
            navigation.navigateBack()
    }) {
        when(operator){
            "ADDITION" -> {
                result = num?.plus(secondOperand) ?: secondOperand
            }
            "SUBTRACTION" -> {
                result = num?.minus(secondOperand) ?: -secondOperand
            }
            "MULTIPLICATION" -> {
                if (num != null) {
                    result = num * secondOperand
                } else {
                    result = 0
                }
            }
            "DIVISION" -> {
                if (num != null) {
                    result = num / secondOperand
                } else {
                    result = 0
                }
            }
        }
        ResultScreenContent(result)
    }
}

@Composable
fun ResultScreenContent(result: Int){

    Column(Modifier.padding(Dp(10F))) {
        Text(text = "Result")
        Text(text = "$result")
    }
}