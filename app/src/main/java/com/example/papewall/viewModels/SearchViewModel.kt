package com.example.papewall.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.papewall.model.domain.Data

import com.example.papewall.model.paging.SearchPagingSource
import com.example.papewall.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = MainRepository()
    var data: MutableLiveData<PagingData<Data>> = MutableLiveData()


    fun searchFromApi(keyWord: String) {
        viewModelScope.launch {
            Pager(config = PagingConfig(pageSize = 30),
                pagingSourceFactory = { SearchPagingSource(repository.retroService(), keyWord) }
            ).flow.cachedIn(viewModelScope).collect {
                data.postValue(it)
            }
        }
    }
}