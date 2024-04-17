package nl.hva.emergencyexitapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun SettingsScreen(
    navHostController: NavHostController, viewModel: SituationViewModel,
) {

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
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = stringResource(id = R.string.settings),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = stringResource(id = R.string.settings_summary),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row(Modifier.padding(8.dp)) {
                Button(
                    onClick = {
                        viewModel.insertDummyData()
                        navHostController.popBackStack()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = coralPink
                    ),
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(
                        text = "Insert dummy data",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Button(
                    onClick = {
                    viewModel.deleteAll()
                        navHostController.popBackStack()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = coralPink
                    ),
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(
                        text = "Delete all",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}