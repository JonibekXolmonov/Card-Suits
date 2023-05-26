package com.frt.cardsuits.utils

import android.content.Context
import android.content.SharedPreferences
import com.frt.cardsuits.utils.Contants.EN
import com.frt.cardsuits.utils.Contants.LANGUAGE
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPref @Inject constructor(@ApplicationContext val context: Context) {

    private val sharedPref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

    fun saveBoolean(key: String, data: Boolean) {
        sharedPref.edit().putBoolean(key, data).apply()
    }

    fun getBoolean(key: String) = sharedPref.getBoolean(key, false)

    fun saveString(key: String = LANGUAGE, data: String) {
        sharedPref.edit().putString(key, data).apply()
    }

    fun getString(key: String = LANGUAGE) = sharedPref.getString(key, EN)


}