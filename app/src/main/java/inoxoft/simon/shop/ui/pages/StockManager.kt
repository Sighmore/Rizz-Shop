package inoxoft.simon.shop.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import inoxoft.simon.shop.model.stock.Stock
import inoxoft.simon.shop.viewmodel.stock.StockViewModel

@Composable
fun CashFlow(modifier: Modifier = Modifier, navController: NavController, viewModel: StockViewModel){
   Column(modifier = modifier
   ) {
       AppHeader()
       CashFlowPage(modifier=Modifier.weight(1f),viewModel)
       BottomBAr(navController)
   }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun CashFlowPage(modifier: Modifier = Modifier, viewModel: StockViewModel) {

    //stores the item added by the user in for of a changing input
    var item by remember {
        mutableStateOf("")
    }
    Stock(
        item
    )
        //creates a list of notes that observes the changes in the database
    val noteList by viewModel.getStock().observeAsState(listOf())
    Row (modifier = modifier
        .fillMaxSize()
        .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top){
            OutlinedTextField(modifier = Modifier
                .width(250.dp)
                .padding(10.dp)
                .weight(1F),
                value =item , onValueChange = {item=it}, label = { Text(text = "Item")})
            Button(

                onClick = {
                    if (item.isNotBlank()) {
                        viewModel.upsertStock(Stock(item)) // Add item to the list
                        item = "" // Clear the text field after adding the
                    }
                }, modifier = Modifier.padding(top = 20.dp)){
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Add item",)
            }



        }
    LazyColumn(modifier=Modifier.fillMaxWidth().padding(start = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        items(noteList.reversed()){note->
            Row(modifier = Modifier
                .fillMaxWidth().
                padding(start = 10.dp, end = 20.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = note.stock)
                IconButton(onClick = { viewModel.deleteStock(note) }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete note")
                    Spacer(modifier = Modifier
                        .height(2.dp)
                        .background(color = Color.Black))
                }
            }
            HorizontalDivider(modifier = Modifier.padding(10.dp))
        }
    }

}

@Composable
fun AppHeader() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.secondaryContainer),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ){
        Text(modifier = Modifier
            .padding(16.dp),
            text = "Shop manager",
            color = Color.White,
            fontSize = 22.sp
        )
       IconButton(onClick = { }) {
           Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Debt Manager", tint = Color.White)
       }
    }
}

@Composable
fun BottomBAr(navController: NavController){
    Row (modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        IconButton(onClick = {
            navController.navigate("cashflow")
        }) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = Color.White)
        }
        IconButton(onClick = {
            navController.navigate("cashmanager")
        }) {
            Icon(imageVector = Icons.Default.DateRange, contentDescription = "finished Stock", tint = Color.White,)
        }
    }
}