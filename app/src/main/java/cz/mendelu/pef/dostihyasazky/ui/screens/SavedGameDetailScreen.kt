package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen
import cz.mendelu.pef.dostihyasazky.ui.elements.MyTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedGameDetailScreen(
    navigation: INavigationRouter,
    id: Long?
) {

    // tod vm get game by id

    BackArrowScreen(
        appBarTitle = "Detail uložené hry",
        onBackClick = { navigation.navigateBack() },
        actions = {
            PlainTooltipBox(
                tooltip = { Text("Smazat hru") }, // todo extract string,
            ) {
                IconButton(onClick = {
//                viewModel.delete Game()
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null
                    )
                }
            }
        }
    ) {
        SavedGameDetailScreenContent()
    }

}

@Composable
fun SavedGameDetailScreenContent() {

    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth()) {

        MyTextField(
            label = "Název",
            value = "",
            enabled = true,
            onValueChange = {
                // vm.on value change(it)
            })
        MyTextField(
            label = "Poznámky",
            value = "",
            enabled = true,
            onValueChange = {
                // vm.on value change(it)
            })

        MyTextField(
            label = "Datum",
            value = "10. 10. 2022",
            enabled = false,
            onValueChange = {
                // vm.on value change(it)
            })
        MyTextField(
            label = "Hráč na řadě",
            value = "1",
            enabled = false,
            onValueChange = {
                // vm.on value change(it)
            })

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedButton(onClick = { /*TODO vm. save */ }) {
                Text(text = "Uložit změny")
            }
            Spacer(Modifier.requiredWidth(32.dp))
            OutlinedButton(onClick = { /*TODO vm. load game */ }) {
                Text(text = "Načíst hru")
            }
        }

    }


}