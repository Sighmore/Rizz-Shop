package inoxoft.simon.shop.viewmodel.cash

import inoxoft.simon.shop.model.cash.CashDatabase
import inoxoft.simon.shop.model.cash.Record

class Repository (private val db: CashDatabase){

    suspend fun upsertRecord(record: Record){
        db.dao.upsertRecord(record)
    }

    suspend fun deleteRecord(record: Record){
        db.dao.deleteRecord(record)
    }
    fun getRecords() = db.dao.getRecords()

}