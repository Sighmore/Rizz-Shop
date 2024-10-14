package inoxoft.simon.shop.model.stock

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stock(
    val stock:String,
    @PrimaryKey(autoGenerate = true)
    val itemId: Int = 0
)
