package inoxoft.simon.shop.viewmodel.stock

import inoxoft.simon.shop.model.stock.Stock
import inoxoft.simon.shop.model.stock.StockDatabase
import kotlinx.coroutines.flow.Flow

class Repository (private val db: StockDatabase){

    suspend fun upsertStock(stock: Stock){
        db.dao.upsertStock(stock)
    }
    suspend fun deleteStock(stock: Stock){
        db.dao.deleteStock(stock)
    }
    fun getStocks() = db.dao.getStocks()

}