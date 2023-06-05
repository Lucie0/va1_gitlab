package cz.mendelu.pef.hw2.ui.screens

import cz.mendelu.pef.hw2.model.Contact as Item

sealed class ContactsListUIState {
    object Default: ContactsListUIState()
    class Success(val items: List<Item>): ContactsListUIState()
}