package com.mcode.mercadolibre.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi


object NetWorkUtils {

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context): Boolean{
        val connectivityManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo = connectivityManager.activeNetwork?: return false
        val activeNw = connectivityManager.getNetworkCapabilities(networkInfo) ?: return false

        return (activeNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || activeNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))

    }
}