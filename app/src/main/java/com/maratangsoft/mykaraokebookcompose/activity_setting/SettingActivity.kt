package com.maratangsoft.mykaraokebookcompose.activity_setting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.theme.BrandColor
import com.maratangsoft.mykaraokebookcompose.theme.MainTheme

class SettingActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SettingScreen() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(){
    MainTheme {
        Scaffold(
            topBar = { SettingTopBar() },
            content = { paddingValues -> SettingContent(paddingValues) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingTopBar(){
    val activity = LocalContext.current as ComponentActivity
    TopAppBar(
        title = { Text(stringResource(R.string.activity_setting)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = BrandColor
        ),
        navigationIcon = {
            IconButton(onClick = { activity.finish() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back"
                )
            }
        }
    )
}

@Composable
fun SettingContent(paddingValues: PaddingValues){
    Column(
        modifier = Modifier.padding(
            top = paddingValues.calculateTopPadding(),
            bottom = 12.dp,
            start = 12.dp,
            end = 12.dp
        )
    ) {
        Text(
            text = stringResource(R.string.txt_brand),
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 12.dp)
        )
        BrandRadioButtons()
        Spacer(modifier = Modifier.height(50.dp))
        FavoriteResetButton()
    }
}

@Composable
fun BrandRadioButtons(){
    var selected by remember { mutableStateOf("") }
    val isSelected: (String) -> Boolean = { selected == it }
    val onChangeState: (String) -> Unit = { selected = it }
    val items = listOf(
        stringResource(R.string.radio_btn_tj),
        stringResource(R.string.radio_btn_ky)
    )
    Row {
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.selectable(
                    selected = isSelected(item),
                    role = Role.RadioButton,
                    onClick = { onChangeState(item) }
                )
            ) {
                RadioButton(
                    selected = isSelected(item),
                    onClick = null
                )
                Text(
                    text = item,
                    modifier = Modifier.padding(start = 8.dp, end = 20.dp)
                )
            }
        }
    }
}

@Composable
fun FavoriteResetButton(){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = BrandColor
        ),
        onClick = {

        }
    ) {
        Text(stringResource(R.string.btn_reset))
    }
}

@Preview
@Composable
fun SettingPreview(){
    SettingScreen()
}