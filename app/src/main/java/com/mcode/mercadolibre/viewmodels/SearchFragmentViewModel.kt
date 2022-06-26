package com.mcode.mercadolibre.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mcode.mercadolibre.usecases.UseCaseSearchList
import com.mcode.mercadolibre.views.adapters.RecentSearchAdapter

class SearchFragmentViewModel(app: Application) : AndroidViewModel(app) {

    val context: Context = app

    var recentSearchList: ArrayList<String> = arrayListOf()
    var recentSearchAdapter = MutableLiveData<RecentSearchAdapter>()

    val useCaseSearchList : UseCaseSearchList = UseCaseSearchList(context)

    var searchKeyWord = MutableLiveData<String>()
    var searchKeyWordSelected = MutableLiveData<String>()

    fun getRecentSearchList(){
        recentSearchList = useCaseSearchList.getSearchList()
        val adapter = RecentSearchAdapter(recentSearchList)
        recentSearchAdapter.value = adapter
        adapter.notifyDataSetChanged()

    }

    fun setSearchKeyWordSelected(searchKeyword: String){
        searchKeyWordSelected.value = searchKeyword
        saveSearchKeyword()
    }

    fun saveSearchKeyword(){
        useCaseSearchList.saveNewSearch(searchKeyWordSelected.value!!, recentSearchList)
    }


}