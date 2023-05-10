package cz.mendelu.pef.cv1.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.cv1.ui.theme.basicMargin
import cz.mendelu.pef.cv1.ui.theme.basicTextStyle
import cz.mendelu.pef.cv1.ui.theme.getBasicTextColor

@Composable
fun PlaceHolderScreen(image: Int?,
                      text: String?){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(basicMargin())) {
            if (image != null) {
                // kdyz vymenim image za progress bar -> loading screen
                Image(
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.width(300.dp), // vyhybat se magickym konstatntam -- dp -- velikost elementu, je nezavisla na velikosti obrazovky; 300 je neco, co se vzdy vejde na obrazovku
                    painter = painterResource(id = image),
                    contentDescription = null)
            }
            Spacer(modifier = Modifier.height(basicMargin()))
            if (text != null){
                Text(text = text,
                    style = basicTextStyle(),
                    textAlign = TextAlign.Center,
                    color = getBasicTextColor())
            }
        }
    }
}