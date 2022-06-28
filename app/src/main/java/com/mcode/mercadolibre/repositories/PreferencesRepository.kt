package com.mcode.mercadolibre.repositories

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mcode.mercadolibre.R

class PreferencesRepository(val context: Context) {

    val sharedPreferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.preferences_name), Context.MODE_PRIVATE)

    fun saveSearchList(searchList: ArrayList<String>){
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(context.getString(R.string.preferences_tag_list), Gson().toJson(searchList))
        editor.commit()
    }

    fun getSearchList(): ArrayList<String>{
        var searchList: ArrayList<String> = ArrayList()
        if(sharedPreferences.contains(context.getString(R.string.preferences_tag_list))){
            val jsonSearchList = sharedPreferences.getString(context.getString(R.string.preferences_tag_list), null)
            searchList = Gson().fromJson(jsonSearchList, object : TypeToken<List<String>>(){}.type)
        }
        return searchList
    }

}