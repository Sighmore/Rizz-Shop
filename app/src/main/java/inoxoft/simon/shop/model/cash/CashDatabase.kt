package inoxoft.simon.shop.model.cash

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Record::class], version = 1)
abstract class CashDatabase : RoomDatabase(){
    abstract val dao: CashDao
}

