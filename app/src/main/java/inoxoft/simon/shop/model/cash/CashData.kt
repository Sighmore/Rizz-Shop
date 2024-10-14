package inoxoft.simon.shop.model.cash

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Record(
    val cash:Int,
    val date:String,
    val mpesaFloat:Int,
    val totalAmount:Int,
    @PrimaryKey(autoGenerate = true)
    val itemId: Int = 0
)