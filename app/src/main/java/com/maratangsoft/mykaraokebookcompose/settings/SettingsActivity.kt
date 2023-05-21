package com.maratangsoft.mykaraokebookcompose.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.maratangsoft.mykaraokebookcompose.Brand
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.main.theme.BrandColor
import com.maratangsoft.mykaraokebookcompose.main.theme.MainTheme

//@AndroidEntryPoint
class SettingsActivity: ComponentActivity() {
    private val viewModel by viewModels<SettingsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SettingScreen(viewModel) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    viewModel: SettingsViewModel? = null
){
    MainTheme {
        Scaffold(
            topBar = { SettingTopBar() },
            content = { paddingValues -> SettingContent(viewModel, paddingValues) }
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
fun SettingContent(
    viewModel: SettingsViewModel?,
    paddingValues: PaddingValues
){
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
        BrandRadioButtons(viewModel)
        Spacer(modifier = Modifier.height(50.dp))
        ResetFavoritesButton(viewModel)
        ExportFavoritesButton(viewModel)
        ImportFavoritesButton(viewModel)
    }
}

@Composable
fun BrandRadioButtons(
    viewModel: SettingsViewModel?
){
    var selected by remember { mutableStateOf(Brand.TJ) }
    val isSelected: (Brand) -> Boolean = { selected == it }
    val onChangeState: (Brand) -> Unit = { selected = it }

    Row {
        Brand.values().forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.selectable(
                    selected = isSelected(item),
                    role = Role.RadioButton,
                    onClick = {
                        onChangeState(item)
                        viewModel?.changeBrand(selected)
                    }
                )
            ) {
                RadioButton(
                    selected = isSelected(item),
                    onClick = null
                )
                Text(
                    text = stringResource(id = item.text),
                    modifier = Modifier.padding(start = 8.dp, end = 20.dp)
                )
            }
        }
    }
}

@Composable
fun ResetFavoritesButton(
    viewModel: SettingsViewModel?
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = BrandColor
        ),
        onClick = { viewModel?.resetFavorites() }
    ) {
        Text(stringResource(R.string.btn_reset_favorites))
    }
}

@Composable
fun ExportFavoritesButton(
    viewModel: SettingsViewModel?
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = BrandColor
        ),
        onClick = { viewModel?.exportFavorites() }
    ) {
        Text(stringResource(R.string.btn_export_favorites))
    }
}

@Composable
fun ImportFavoritesButton(
    viewModel: SettingsViewModel?
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = BrandColor
        ),
        onClick = { viewModel?.importFavorites() }
    ) {
        Text(stringResource(R.string.btn_import_favorites))
    }
}

@Preview
@Composable
fun SettingPreview(){
    SettingScreen()
}