package inoxoft.simon.shop.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import inoxoft.simon.shop.model.cash.Record
import inoxoft.simon.shop.viewmodel.cash.CashViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun CashManager(modifier: Modifier = Modifier, navController: NavController, viewModel: CashViewModel) {
    Column(
        modifier = modifier
    ) {
        AppHeader()
        CashManagerPage(modifier = Modifier.weight(1f), viewModel)
        BottomBAr(navController)
    }
}

@Composable
fun CashManagerPage(modifier: Modifier = Modifier, viewModel: CashViewModel) {
    var cash by remember {
        mutableStateOf("")
    }
    var mpesaFloat by remember {
        mutableStateOf("")
    }
    val recordList by viewModel.getRecords().observeAsState(listOf())

    Column(modifier, verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(modifier=Modifier.padding(10.dp), text = "Cash and Float manager", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp), horizontalArrangement = Arrangement.SpaceEvenly){
            OutlinedTextField(modifier = Modifier
                .padding(5.dp)
                .width(100.dp),
                value = cash, onValueChange = {cash=it}, label = { Text(text = "Cash")})
            OutlinedTextField(modifier = Modifier
                .padding(5.dp)
                .width(100.dp),
                value = mpesaFloat, onValueChange = {mpesaFloat=it}, label = { Text(text = "Float")})
            IconButton(
                onClick = {
                    if (cash.isNotBlank() && mpesaFloat.isNotEmpty()) {
                        val currentDateTime = LocalDateTime.now()
                        val formattedDate = currentDateTime.format(DateTimeFormatter.ofPattern("MMM dd"))
                        viewModel.upsertRecord(Record(cash.toInt(),formattedDate.toString(),mpesaFloat.toInt(), totalAmount = cash.toInt()+mpesaFloat.toInt())) // Add item to the list
                        cash = "" // Clear the text field after adding the
                        mpesaFloat=""
                    }
            }, modifier = Modifier.padding(top = 20.dp)) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add entry")
            }
        }
        Row( modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(modifier=Modifier.padding(10.dp),text = "Date")
            Text(modifier=Modifier.padding(10.dp),text = "Cash")
            Text(modifier=Modifier.padding(10.dp),text = "Float")
            Text(modifier=Modifier.padding(10.dp),text = "Total")
        }
        LazyColumn {

            items(recordList.reversed()) { Record ->
                Row(
                    modifier = Modifier.padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(modifier=Modifier.padding(10.dp),
                        text = Record.date)
                    Text(modifier=Modifier.padding(10.dp),text = Record.cash.toString())
                    Text(modifier=Modifier.padding(10.dp),text = Record.mpesaFloat.toString())
                    Text(modifier=Modifier.padding(10.dp),text = Record.totalAmount.toString())
                    IconButton(onClick = {
                        viewModel.deleteRecord(Record)
                    },modifier=Modifier.padding(10.dp)) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                    }
                }
                HorizontalDivider(modifier = Modifier.padding(10.dp))

            }
        }
    }
}