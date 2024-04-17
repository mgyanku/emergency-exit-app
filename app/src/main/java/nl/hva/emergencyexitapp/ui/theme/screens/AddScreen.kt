package nl.hva.emergencyexitapp.ui.theme.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import nl.hva.emergencyexitapp.R
import nl.hva.emergencyexitapp.data.model.Situation
import nl.hva.emergencyexitapp.ui.theme.coralPink
import nl.hva.emergencyexitapp.viewmodel.SituationViewModel

@Composable
fun AddScreen(
    navHostController: NavHostController, viewModel: SituationViewModel
) {
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var instruction by remember { mutableStateOf("") }

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
                Text(
                    text = stringResource(id = R.string.add_title),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = stringResource(id = R.string.add_summary),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column(Modifier.padding(20.dp)) {
                CustomTextField(value = title, onValueChange = {title = it}, label = "Situation",
                    keyboardType = KeyboardType.Text, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.padding(20.dp))
                CustomTextField(value = instruction, onValueChange = {instruction = it}, label = "Instruction",
                    keyboardType = KeyboardType.Text, modifier = Modifier
                        .fillMaxWidth())
                Spacer(modifier = Modifier.padding(20.dp))
                Button(onClick = {
                                 val newInstruction = verifyInput(context, title, instruction)
                                    if(newInstruction.title.isNotEmpty()) {
                                        viewModel.insert(newInstruction)
                                        navHostController.popBackStack()
                                    }
                                 },  colors = ButtonDefaults.buttonColors(
                    containerColor = coralPink
                ),
                    modifier = Modifier.padding(5.dp)) {
                    Text(text = stringResource(id = R.string.add_button))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent
        ),
        singleLine = true,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

private  fun verifyInput(
    context: Context, title: String, instruction: String
) : Situation {

    if (title.isEmpty()) {
        Toast.makeText(context, context.getText(R.string.empty_title), Toast.LENGTH_SHORT).show()
    } else if (instruction.isEmpty()) {
        Toast.makeText(context, context.getText(R.string.empty_instruction), Toast.LENGTH_SHORT).show()
    }

    if (title.isNotBlank() && instruction.isNotBlank()) {
        return Situation(title, instruction)
    }
        return Situation("", "")
}