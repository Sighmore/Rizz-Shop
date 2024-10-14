package inoxoft.simon.shop.model.stock

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface StockDao {

    @Upsert
    suspend fun upsertStock(stock: Stock)

    @Delete
    suspend fun deleteStock(stock: Stock)

    @Query("SELECT * FROM stock")
    fun getStocks(): Flow<List<Stock>>
}