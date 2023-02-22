package cz.mendelu.pef.cv1.ui.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import cz.mendelu.pef.cv1.ui.screens.AddEditTaskScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackArrowScreen(
    appBarTitle: String,
    onBackClick: () -> Unit,
    content: @Composable (paddingValues: PaddingValues) -> Unit
){
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = appBarTitle)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackClick()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "")
                    }
                }
            )
        }) { // slozene zavorky, kdy jsou cervene podtrzene, nejsou potreba
        content(it) // poslan parametr paddingValues
    }

}