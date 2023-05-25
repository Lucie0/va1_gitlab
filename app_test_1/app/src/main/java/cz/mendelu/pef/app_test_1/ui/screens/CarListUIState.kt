package cz.mendelu.pef.app_test_1.ui.screens

import cz.mendelu.pef.app_test_1.model.Car as Item

sealed class CarListUIState {
    object Default: CarListUIState()
    class Success(val items: List<Item>): CarListUIState()
}