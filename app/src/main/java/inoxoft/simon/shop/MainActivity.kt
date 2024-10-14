package inoxoft.simon.shop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import inoxoft.simon.shop.model.stock.StockDatabase
import inoxoft.simon.shop.ui.ShopNavigation
import inoxoft.simon.shop.ui.theme.ShopTheme
import inoxoft.simon.shop.viewmodel.stock.Repository
import inoxoft.simon.shop.viewmodel.stock.StockViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //creation of a db
        val db by lazy {
            Room.databaseBuilder(applicationContext, StockDatabase::class.java, name="stock.db").build()
        }
        //creation of a viewmodel
        val viewModel by viewModels<StockViewModel>(
            factoryProducer ={
                object : ViewModelProvider.Factory{
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return StockViewModel(Repository(db)) as T
                    }
                }
            }
        )
        setContent {
            ShopTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        ShopNavigation(modifier = Modifier.padding(innerPadding),viewModel)

                }
            }
        }
    }
}
