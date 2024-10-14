package inoxoft.simon.shop.model.cash

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CashDao {


    @Upsert
    //parameter stock of type Stock
    suspend fun upsertRecord(record: Record)

    @Delete
    suspend fun deleteRecord(record: Record)

    @Query("SELECT * FROM Record")
    fun getRecords(): Flow<List<Record>>
}
