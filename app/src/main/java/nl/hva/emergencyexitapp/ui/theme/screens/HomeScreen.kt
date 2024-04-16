package nl.hva.emergencyexitapp.ui.theme.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import nl.hva.emergencyexitapp.ui.theme.EmergencyExitAppTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import nl.hva.emergencyexitapp.R
import nl.hva.emergencyexitapp.ui.theme.coralPink


@Composable
fun HomeScreen(navHostController: NavHostController) {
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = R.string.situation_widget_title),
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = stringResource(id = R.string.situation_widget_status),
                    style = MaterialTheme.typography.headlineSmall,
                    color = coralPink
                )
                Text(
                    text = stringResource(id = R.string.situation_widget_summary),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Row(modifier = Modifier.padding(10.dp)) {
                Button(
                    onClick = {
                        navHostController.navigate("${AppScreens.InstructionScreen.route}/4")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = coralPink
                    ),
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.situation_widget_button_instructions),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(id = R.string.speed_dial_widget_title),
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(Modifier.padding(10.dp))
                Row {
                    CircularButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:0900-8844")
                            }
                            context.startActivity(intent)
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ambulance),
                            contentDescription = "ambulance", // decorative element
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                        )
                    }
                    CircularButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:0900-8844")
                            }
                            context.startActivity(intent)
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.police),
                            contentDescription = "police", // decorative element
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                        )
                    }
                    CircularButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:0900-8844")
                            }
                            context.startActivity(intent)
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.firefighter),
                            contentDescription = "firemen", // decorative element
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                        )
                    }
                }
            }

        }
    }


}

@Composable
fun CircularButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(8.dp)
            .size(90.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = coralPink
        ),
        border = BorderStroke(2.dp, coralPink)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}