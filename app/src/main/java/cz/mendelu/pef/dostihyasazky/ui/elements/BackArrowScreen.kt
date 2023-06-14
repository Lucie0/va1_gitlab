package cz.mendelu.pef.dostihyasazky.ui.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackArrowScreen(
    appBarTitle: String,
    onBackClick: () -> Unit,
    drawFullScreenContent: Boolean = false,
    actions: @Composable RowScope.() -> Unit = {}, // tlacitka vpravo nahore v toolbaru
    content: @Composable (paddingValues: PaddingValues) -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                actions = actions,
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

        if(!drawFullScreenContent) {
            LazyColumn(modifier = Modifier.padding(it)) {
                item { // content bez item hazel err, ze volame composable v necomposable fci, reseni: item
                    content(it) // poslan parametr paddingValues
                }
            }
        } else {
            content(it)
        }

    }

}
