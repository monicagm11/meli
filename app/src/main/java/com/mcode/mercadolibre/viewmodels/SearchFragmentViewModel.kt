package com.mcode.mercadolibre.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mcode.mercadolibre.usecases.UseCaseSearchList
import com.mcode.mercadolibre.views.adapters.RecentSearchAdapter

class SearchFragmentViewModel(app: Application) : AndroidViewModel(app) {

    val context: Context = app
    var recentSearchAdapter = MutableLiveData<RecentSearchAdapter>()

    val useCaseSearchList : UseCaseSearchList = UseCaseSearchList(context)


    fun getRecentSearchList(){
        var recentSearchList = useCaseSearchList.getSearchList()
        val adapter = RecentSearchAdapter(recentSearchList)
        recentSearchAdapter.value = adapter
        adapter.notifyDataSetChanged()

    }


}