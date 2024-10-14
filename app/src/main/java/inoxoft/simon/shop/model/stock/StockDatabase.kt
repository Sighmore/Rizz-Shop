package inoxoft.simon.shop.model.stock

import androidx.room.Database
import androidx.room.RoomDatabase

//a creation of a database blueprint for concrete database implementation
//handles database creation and implementation
@Database(entities = [Stock::class], version = 1)
abstract class StockDatabase : RoomDatabase(){

    abstract val dao: StockDao


}