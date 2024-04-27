package com.example.myapplication.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.sp_logicgames.App.AppScreen
import com.example.sp_logicgames.Game.Game


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MenuUI(
    navController: NavHostController,
    games: List<Game>,
    modifier: Modifier = Modifier
){
    var text by remember { mutableStateOf("")}
        var active by remember { mutableStateOf(false)}
        var pomocna = ""
        var items = remember {
            mutableStateListOf<String>()
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            val listState = rememberLazyListState()
            LazyColumn(state = listState, modifier = modifier.padding(vertical = 4.dp)) {
                items.forEach() { game ->
                    if (pomocna.isEmpty() || stringResource(affirmation.stringResourceId).contains(pomocna)) {
                        Greeting(affirmation = affirmation, "ahoj", NavController)
                    }
                }


            }
            LaunchedEffect(key1 = pomocna) {
                listState.scrollToItem(0)

            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(affirmation: Affirmation,name: String, navController: NavHostController,modifier: Modifier = Modifier) {
    val gameName =stringResource(affirmation.stringResourceId)


    Card(

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),

        modifier = modifier
            .clickable(onClick = { navController.navigate(AppScreen.Game.rout + "/$gameName") }) // Add clickable modifier here
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column{
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            CardContent(gameName)

        }

    }
}


//@Preview
//@Composable
//fun prevcomb(){
//    val navController = rememberNavController()
//    Greetings(affirmationList = Datasource().loadAffirmations(), NavController = navController)
//}
@Composable
private fun CardContent(name: String) {
    //var expanded by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Score ")
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
//            if (expanded) {
//                Text(
//                    text = ("Composem ipsum color sit lazy, " +
//                            "padding theme elit, sed do bouncy. ").repeat(4),
//                )
//            }
        }
    }
}