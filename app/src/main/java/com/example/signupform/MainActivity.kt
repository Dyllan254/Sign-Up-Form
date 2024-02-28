package com.example.signupform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.signupform.ui.theme.SignUpFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun SignUp( modifier: Modifier = Modifier) {
    var inputFirstName by remember{ mutableStateOf("") }
    var inputLastName by remember { mutableStateOf("") }
    var inputEmailAddress by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var inputConfirmPassword by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
    ) {
        Text(text = stringResource(id = R.string.sign_up))
        Spacer(modifier = Modifier.height(40.dp))

        EditTextField(
            label = R.string.first_name,
            leadingIcon = R.drawable.name,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = inputFirstName,
            onValueChange = { inputFirstName = it },
            modifier = Modifier
                .weight(1F)
        )
        Spacer(modifier = Modifier.height(20.dp))
        EditTextField(
            label = R.string.last_name,
            leadingIcon = R.drawable.name,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = inputLastName,
            onValueChange = { inputLastName = it },
            modifier = Modifier.weight(1F)
        )
        Spacer(modifier = Modifier.height(20.dp))
        EditTextField(
            label = R.string.email_address,
            leadingIcon = R.drawable.email,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = inputEmailAddress,
            onValueChange = {inputEmailAddress = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        EditTextField(
            label = R.string.password,
            leadingIcon = R.drawable.password ,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            value = inputPassword,
            onValueChange = {inputPassword = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        EditTextField(
            label = R.string.confirm_password,
            leadingIcon = R.drawable.confirm_password,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = inputConfirmPassword,
            onValueChange = {inputConfirmPassword = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.sign_up))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.or_sign_up_with))
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = null,
                modifier = Modifier.clickable { }
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = null,
                modifier = Modifier.clickable { }
            )
        }
        
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = {Text(text = stringResource(id = label))},
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), contentDescription = null)},
        keyboardOptions = keyboardOptions
    )

}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUpFormTheme {
        SignUp()
    }
}