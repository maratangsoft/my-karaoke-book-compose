package com.maratangsoft.mykaraokebookcompose.activity_main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.repos.TjRepository
import com.maratangsoft.mykaraokebookcompose.theme.BrandColor

@Composable
fun PopularScreen(){
    val songs = remember { TjRepository().songs }
    ScreenLayout(
        songs = songs,
        topBar = { PopularTopBar() },
        recyclerView = { SearchRecyclerView(items = songs) }
    )
}

@Composable
fun PopularTopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(topBarSize),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.width(32.dp))
        SelectLanguageButton()
        SettingButton()
    }
}

@Composable
fun SelectLanguageButton() {
    var isExpanded by remember { mutableStateOf(false) }

    val txtKo = stringResource(R.string.lan_ko)
    val txtEn = stringResource(R.string.lan_en)
    val txtJa = stringResource(R.string.lan_ja)
    val txtZh = stringResource(R.string.lan_zh)
    var btnText by remember { mutableStateOf(txtKo) }

    Column {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = BrandColor),
            contentPadding = PaddingValues(start = 4.dp, end = 8.dp),
            shape = RoundedCornerShape(6.dp),
            onClick = { isExpanded = true }
        ) {
            Row {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.ic_arrow_down)
                )
                Text(btnText)
            }
        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(txtKo) },
                onClick = {
                    btnText = txtKo
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(txtEn) },
                onClick = {
                    btnText = txtEn
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(txtJa) },
                onClick = {
                    btnText = txtJa
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(txtZh) },
                onClick = {
                    btnText = txtZh
                    isExpanded = false
                }
            )
        }
    }
}

@Preview
@Composable
fun PopularScreenPreview(){
    PopularScreen()
}