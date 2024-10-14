package inoxoft.simon.shop.model.cash

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Record(
    val cash:String,
    val date:String,
    val mpesaFloat:String,
    val totalAmount:String,
    @PrimaryKey(autoGenerate = true)
    val itemId: Int = 0
)