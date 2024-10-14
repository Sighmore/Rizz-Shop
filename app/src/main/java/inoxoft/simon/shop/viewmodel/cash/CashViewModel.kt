package inoxoft.simon.shop.viewmodel.cash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import inoxoft.simon.shop.model.cash.Record
import inoxoft.simon.shop.viewmodel.cash.Repository
import kotlinx.coroutines.launch

class CashViewModel(private val repository: Repository): ViewModel(){

    fun getRecords()=repository.getRecords().asLiveData(viewModelScope.coroutineContext)

    fun upsertRecord(record: Record)=viewModelScope.launch {
        repository.upsertRecord(record)
    }
    fun deleteRecord(record: Record)=viewModelScope.launch {
        repository.deleteRecord(record)

    }

}