package com.mcode.mercadolibre.usecases

import android.content.Context
import com.mcode.mercadolibre.repositories.PreferencesRepository

class UseCaseSearchList(context: Context) {

    val preferencesRepository : PreferencesRepository =  PreferencesRepository(context)
    val MAX_SEARCH = 10

    fun getSearchList(): ArrayList<String>{
        return preferencesRepository.getSearchList()
    }

    fun saveNewSearch(newSearch: String, searchList: ArrayList<String>){
        val list = validateNewSearch(newSearch, searchList)
        preferencesRepository.saveSearchList(list)
    }

    fun validateNewSearch(newSearch: String, searchList: ArrayList<String>): ArrayList<String>{
        if(searchList.isEmpty()){
            searchList.add(newSearch)
        }else{
            var previewSearchIndex = searchList.indexOfFirst { it == newSearch }
            if(previewSearchIndex > 0){
                searchList.removeAt(previewSearchIndex)
            }
            searchList.add(0, newSearch)
        }

        val length = Math.min(MAX_SEARCH, searchList.size)

        return searchList.take(length) as ArrayList<String>


    }

}