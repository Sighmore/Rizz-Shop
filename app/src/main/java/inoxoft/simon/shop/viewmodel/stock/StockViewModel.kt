package inoxoft.simon.shop.viewmodel.stock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import inoxoft.simon.shop.model.stock.Stock
import kotlinx.coroutines.launch

class StockViewModel (private val repository: Repository): ViewModel(){

    fun getStock()=repository.getStocks().asLiveData(viewModelScope.coroutineContext)

    fun upsertStock(stock: Stock)=viewModelScope.launch {
        repository.upsertStock(stock)
    }
    fun deleteStock(stock: Stock)=viewModelScope.launch {
        repository.deleteStock(stock)

    }

}