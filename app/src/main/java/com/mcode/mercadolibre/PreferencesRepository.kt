package com.mcode.mercadolibre

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PreferencesRepository(context: Context) {

    val sharedPreferences: SharedPreferences = context.getSharedPreferences("sp_mercado_libre", Context.MODE_PRIVATE)
    val TAG_SEARCH_LIST = "search_list"


    fun saveSearchList(searchList: ArrayList<String>){
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(TAG_SEARCH_LIST, Gson().toJson(searchList))
        editor.commit()
    }

    fun getSearchList(): ArrayList<String>{
        var searchList: ArrayList<String> = ArrayList()
        if(sharedPreferences.contains(TAG_SEARCH_LIST)){
            val jsonSearchList = sharedPreferences.getString(TAG_SEARCH_LIST, null)
            searchList = Gson().fromJson(jsonSearchList, object : TypeToken<List<String>>(){}.type)
        }
        return searchList
    }

}