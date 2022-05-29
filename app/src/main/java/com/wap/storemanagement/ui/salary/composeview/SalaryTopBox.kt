package com.wap.storemanagement.ui.salary.composeview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wap.storemanagement.R

@Composable
fun TopBox(salary: Int) {
    var holidayToggleState by remember { mutableStateOf(false)}

    Column(
        modifier = Modifier.background(color = colorResource(id = R.color.dark_blue)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Title()
        TotalSalary(salary, holidayToggleState)
        HolidayPay() { holidayToggleState = !holidayToggleState }
    }
}

@Composable
private fun Title() {
    WhiteText(text = stringResource(id = R.string.calculate_salary), size = 16)
}

@Composable
private fun TotalSalary(salary: Int, holidayToggleState: Boolean) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(0.9f)
    ) {
        Text(
            text = "${if (!holidayToggleState) salary else calculateHolidaySalary(salary)} 원",
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
                .fillMaxWidth(),
            color = Color.Black,
            textAlign = TextAlign.End
        )
    }
}

// TODO: 일한시간을 받아 주휴수당을 반환
private fun calculateHolidaySalary(salary: Int) = salary

@Composable
private fun HolidayPay(calculate: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        WhiteText(text = stringResource(R.string.holiday_salary), size = 16)
        Switch(checked = false, onCheckedChange = { calculate() })
    }
}

@Preview(widthDp = 240, heightDp = 320)
@Composable
private fun TopBoxPreview() {
    TopBox(5000000)
}
