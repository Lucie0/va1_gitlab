package cz.mendelu.pef.homework1.navigation

import androidx.navigation.NavController
import cz.mendelu.pef.homework1.ui.elements.Operators

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {
    override fun navigateBack() {
        // do stacku se pridavaji obrazovky, neaktivni jsou uspane,
        // posledni (aktivni) polozka se vyhodi
        navController.popBackStack()
    }

    override fun navigateToOperationScreen(num: Int?) {
        // predani parametru -- cisla, se kterym se maji delat operace
        navController.navigate(Destination.OperationScreen.route + "/" + num)
    }

//    override fun navigateToResultScreen(operator: Operators, num: Int?) { // todo param enum
//        // (druhy operand je 3)
//        navController.navigate(Destination.ResultScreen.route + "/" + operator + "/" + num)
//        println(operator)
//        println(num)
//    }

    override fun navigateToResultScreen(operator: String, num: Int?) {
        // (druhy operand je 3)
        navController.navigate(Destination.ResultScreen.route + "/" + operator + "/" + num) // todo spatny string ADD, predelat na enum.ADD
        println(operator)
        println(num)
    }

    // getter
    override fun getNavController(): NavController = navController
}