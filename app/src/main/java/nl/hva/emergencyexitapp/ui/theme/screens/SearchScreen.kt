package nl.hva.emergencyexitapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import nl.hva.emergencyexitapp.R
import nl.hva.emergencyexitapp.ui.theme.coralPink
import nl.hva.emergencyexitapp.ui.theme.white

@Composable
fun SearchScreen(navHostController: NavHostController) {
    //we use rememberSaveable here to let the state survive process death, remember++ so to speak
    val searchQueryState = rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(""))
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
//                Title of screen
                Text(
                    text = stringResource(id = R.string.search_title),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                //            Searchbar
                TextField(
                    value = searchQueryState.value,
                    onValueChange = { value ->
                        searchQueryState.value = value
                    },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(fontSize = 18.sp),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(16.dp)
                                .size(24.dp)
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.search_title)
                        )
                    },
                    singleLine = true,
                    shape = RectangleShape // The TextFiled has rounded corners top left and right by default
                )
            }
//            list of items
            Column(modifier = Modifier.padding(10.dp)) {
//                each button is a item
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = coralPink
                    ),
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.situation_widget_status),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = coralPink
                    ),
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.situation_widget_status),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

        }
    }
}