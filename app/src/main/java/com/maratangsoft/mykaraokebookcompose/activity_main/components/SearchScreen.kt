package com.maratangsoft.mykaraokebookcompose.activity_main.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
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
import androidx.compose.ui.unit.sp
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.model.Song
import com.maratangsoft.mykaraokebookcompose.repos.TjRepository
import com.maratangsoft.mykaraokebookcompose.theme.BrandColor

@Composable
fun SearchScreen(){
    val songs = remember { TjRepository().songs }
    ScreenLayout(
        songs = songs,
        topBar = { SearchTopBar() },
        recyclerView = { SearchRecyclerView(items = songs) }
    )
}

@Composable
fun SearchTopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(topBarSize),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .border(1.dp, BrandColor, RoundedCornerShape(6.dp))
                .weight(1f, true),
        ) {
            SearchOptionButton()
            SearchTextField(modifier = Modifier.fillMaxWidth())
        }
        Spacer(modifier = Modifier.padding(4.dp))
        SettingButton()
    }
}

@Composable
fun SearchRecyclerView(items: List<Song>){
    LazyColumn{
        items(
            items = items,
            itemContent = { SearchItem(it) }
        )
    }
}

@Composable
fun SearchTextField(modifier: Modifier){
    val value by remember { mutableStateOf("") }
    BasicTextField(
        value = value,
        onValueChange = {},
        modifier = modifier
            .fillMaxHeight()
            .padding(8.dp, 0.dp)
        ,
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = "search...",
                        fontSize = 16.sp
                    )
                }
            }
            innerTextField()
        }
    )
}

@Composable
fun SearchOptionButton() {
    var isExpanded by remember { mutableStateOf(false) }

    val txtNo = stringResource(R.string.search_dropdown_title)
    val txtTitle = stringResource(R.string.search_dropdown_singer)
    val txtSinger = stringResource(R.string.search_dropdown_no)
    var btnText by remember { mutableStateOf(txtNo) }

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
                text = { Text(txtTitle) },
                onClick = {
                    btnText = txtTitle
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(txtSinger) },
                onClick = {
                    btnText = txtSinger
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(txtNo) },
                onClick = {
                    btnText = txtNo
                    isExpanded = false
                }
            )
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview(){
    SearchScreen()
}