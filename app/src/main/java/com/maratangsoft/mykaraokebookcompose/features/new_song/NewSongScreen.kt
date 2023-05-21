package com.maratangsoft.mykaraokebookcompose.features.new_song

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maratangsoft.mykaraokebookcompose.R
import com.maratangsoft.mykaraokebookcompose.data.network.TjDataSource
import com.maratangsoft.mykaraokebookcompose.features.favorites.topBarSize
import com.maratangsoft.mykaraokebookcompose.main.CommonRecyclerView
import com.maratangsoft.mykaraokebookcompose.main.ScreenLayout
import com.maratangsoft.mykaraokebookcompose.main.theme.BrandColor
import java.util.GregorianCalendar

@Composable
fun NewSongScreen(
    viewModel: NewSongViewModel = viewModel() // hilt 쓸때는 뺄 것
){

    val songs = remember { TjDataSource().songs }
    ScreenLayout(
        topBar = { NewSongTopBar() },
        recyclerView = { CommonRecyclerView(items = songs) }
    )
}

@Composable
fun NewSongTopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(topBarSize),
        horizontalArrangement = Arrangement.Center
    ) {
        SelectMonthButton()
    }
}

@Composable
fun SelectMonthButton() {
    var isExpanded by remember { mutableStateOf(false) }

    fun getDateString(monthBefore: Int): String {
        val now = GregorianCalendar.getInstance()
        val year = now.get(GregorianCalendar.YEAR)
        val month = now.get(GregorianCalendar.MONTH) + 1 - monthBefore

        return "${year}년 ${month}월"
    }
    var btnText by remember { mutableStateOf(getDateString(0)) }

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
                text = { Text(getDateString(0)) },
                onClick = {
                    btnText = getDateString(0)
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(getDateString(1)) },
                onClick = {
                    btnText = getDateString(1)
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(getDateString(2)) },
                onClick = {
                    btnText = getDateString(2)
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(getDateString(3)) },
                onClick = {
                    btnText = getDateString(3)
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(getDateString(4)) },
                onClick = {
                    btnText = getDateString(4)
                    isExpanded = false
                }
            )
        }
    }
}

@Preview
@Composable
fun NewSongScreenPreview(){
    NewSongScreen()
}