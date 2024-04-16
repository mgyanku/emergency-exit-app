package nl.hva.emergencyexitapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import nl.hva.emergencyexitapp.R
import nl.hva.emergencyexitapp.ui.theme.coralPink
import nl.hva.emergencyexitapp.viewmodel.SituationViewModel

@Composable
fun InstructionScreen(
    navHostController: NavHostController, viewModel: SituationViewModel,
    situationId: Int
) {

    val backlog = viewModel.backlog
    
    
    val situation = backlog.value?.get(situationId)

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
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                if (situation != null) {
                    Text(
                        text = situation.title,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = situation.instruction,
                        style = MaterialTheme.typography.bodyLarge
                    )
                } else {
                    Text(text = "Something went wrong.")
                }
            }
            Column (
                modifier = Modifier.padding(15.dp)
            ) {
                Button(
                    onClick = { 
                              navHostController.navigate(AppScreens.HomeScreen.route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = coralPink
                    ),
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(
                        text = "Back",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }


}